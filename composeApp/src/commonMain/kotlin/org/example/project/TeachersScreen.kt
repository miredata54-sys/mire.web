package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Teacher(
    val name: String,
    val subject: String,
    val phone: String,
    val email: String
)

@Composable
fun TeachersScreen() {

    var teachers by remember { mutableStateOf(listOf<Teacher>()) }
    var showForm by remember { mutableStateOf(false) }
    var editIndex by remember { mutableStateOf<Int?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    // Form state
    var name by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val filteredTeachers = teachers.filter {
        it.name.contains(searchQuery, true) ||
                it.subject.contains(searchQuery, true)
    }

    MainContentArea(title = "Teachers") {

        if (showForm) {

            // ===== ADD / EDIT FORM =====
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = if (editIndex == null) "Add Teacher" else "Edit Teacher",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(name, { name = it }, label = { Text("Teacher Name") })
                OutlinedTextField(subject, { subject = it }, label = { Text("Subject") })
                OutlinedTextField(phone, { phone = it }, label = { Text("Phone Number") })
                OutlinedTextField(email, { email = it }, label = { Text("Email Address") })

                Button(
                    onClick = {
                        val teacher = Teacher(name, subject, phone, email)

                        teachers =
                            if (editIndex == null) {
                                teachers + teacher
                            } else {
                                teachers.toMutableList().also {
                                    it[editIndex!!] = teacher
                                }
                            }

                        // Reset
                        name = ""
                        subject = ""
                        phone = ""
                        email = ""
                        editIndex = null
                        showForm = false
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Save")
                }
            }

        } else {

            // ===== LIST + SEARCH =====
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Teachers Management",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333)
                    )

                    Button(onClick = { showForm = true }) {
                        Text("+ Add")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search teachers") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (filteredTeachers.isEmpty()) {
                    Text("No teachers found", color = Color.Gray)
                } else {
                    filteredTeachers.forEachIndexed { index, teacher ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(teacher.name, fontWeight = FontWeight.Bold)
                                    Text("Subject: ${teacher.subject}")
                                    Text("Phone: ${teacher.phone}")
                                }

                                Row {
                                    IconButton(
                                        onClick = {
                                            editIndex = index
                                            name = teacher.name
                                            subject = teacher.subject
                                            phone = teacher.phone
                                            email = teacher.email
                                            showForm = true
                                        }
                                    ) {
//                                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                                    }

                                    IconButton(
                                        onClick = {
                                            teachers = teachers.toMutableList().also {
                                                it.removeAt(index)
                                            }
                                        }
                                    ) {
//                                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

