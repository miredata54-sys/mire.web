package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mire_data_app.composeapp.generated.resources.Res
import mire_data_app.composeapp.generated.resources.deleta
import mire_data_app.composeapp.generated.resources.edit_
import org.jetbrains.compose.resources.painterResource

data class Teacher(
    val name: String,
    val subject: String,
    val phone: String,
    val pic: String
)

@Composable
fun TeachersScreen() {

    var teachers by remember { mutableStateOf(listOf<Teacher>()) }
    var showDialog by remember { mutableStateOf(false) }
    var editIndex by remember { mutableStateOf<Int?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    // Form state
    var name by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var pic by remember { mutableStateOf("") }

    val filteredTeachers = teachers.filter {
        it.name.contains(searchQuery, true) ||
                it.subject.contains(searchQuery, true)
    }

    MainContentArea(title = "Teachers") {

        // ================= LIST + SEARCH =================
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

                Button(
                    onClick = {
                        editIndex = null
                        clearTeacherForm {
                            name = ""
                            subject = ""
                            phone = ""
                            pic = ""
                        }
                        showDialog = true
                    }
                ) {
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
                                        pic = teacher.pic
                                        showDialog = true
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(Res.drawable.edit_),
                                        contentDescription = "Profile Picture",

                                        modifier = Modifier
                                    )
                                    Color(0xFF000000)
                                }

                                IconButton(
                                    onClick = {
                                        teachers = teachers.toMutableList().also {
                                            it.removeAt(index)
                                        }
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(Res.drawable.deleta),
                                        contentDescription = "Profile Picture",

                                        modifier = Modifier
                                    )
                                    Color(0xFFFF0000)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ================= ADD / EDIT DIALOG =================
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(
                    onClick = {
                        val teacher = Teacher(name, subject, phone, pic)

                        teachers =
                            if (editIndex == null) {
                                teachers + teacher
                            } else {
                                teachers.toMutableList().also {
                                    it[editIndex!!] = teacher
                                }
                            }

                        showDialog = false
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            },
            title = {
                Text(
                    text = if (editIndex == null) "Add Teacher" else "Edit Teacher",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(name, { name = it }, label = { Text("Teacher Name") })
                    OutlinedTextField(subject, { subject = it }, label = { Text("Subject") })
                    OutlinedTextField(phone, { phone = it }, label = { Text("Phone Number") })
                    OutlinedTextField(pic, { pic = it }, label = { Text("Email Address") })
                }
            }
        )
    }
}

private fun clearTeacherForm(onClear: () -> Unit) {
    onClear()
}
