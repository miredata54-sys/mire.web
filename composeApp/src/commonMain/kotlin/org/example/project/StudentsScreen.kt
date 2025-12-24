package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Student(
    val fullName: String,
    val dob: String,
    val age: String,
    val gender: String,
    val grade: String,
    val schoolName: String,
    val address: String,
    val phone: String,
    val email: String
)

@Composable
fun StudentsScreen() {

    var showDialog by remember { mutableStateOf(false) }
    var students by remember { mutableStateOf(listOf<Student>()) }
    var editIndex by remember { mutableStateOf<Int?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    // Form state
    var fullName by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var schoolName by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }

    val filteredStudents = students.filter {
        it.fullName.contains(searchQuery, true) ||
                it.grade.contains(searchQuery, true)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    editIndex = null
                    clearForm(
                        onClear = {
                            fullName = ""
                            dob = ""
                            age = ""
                            grade = ""
                            schoolName = ""
                            address = ""
                            phone = ""
                            email = ""
                            gender = "Male"
                        }
                    )
                    showDialog = true
                }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Students",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (filteredStudents.isEmpty()) {
                Text("No students found")
            } else {
                filteredStudents.forEachIndexed { index, student ->
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
                                Text(student.fullName, fontWeight = FontWeight.Bold)
                                Text("Grade: ${student.grade}")
                                Text("Phone: ${student.phone}")
                            }

                            Row {
                                IconButton(
                                    onClick = {
                                        editIndex = index
                                        fullName = student.fullName
                                        dob = student.dob
                                        age = student.age
                                        gender = student.gender
                                        grade = student.grade
                                        schoolName = student.schoolName
                                        address = student.address
                                        phone = student.phone
                                        email = student.email
                                        showDialog = true
                                    }
                                ) {
//                                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                                }

                                IconButton(
                                    onClick = {
                                        students = students.toMutableList().also {
                                            it.removeAt(index)
                                        }
                                    }
                                ) {
//                                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ===================== DIALOG =====================
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = {
                    val student = Student(
                        fullName, dob, age, gender, grade,
                        schoolName, address, phone, email
                    )

                    students =
                        if (editIndex == null) {
                            students + student
                        } else {
                            students.toMutableList().also {
                                it[editIndex!!] = student
                            }
                        }

                    showDialog = false
                }) {
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
                    if (editIndex == null) "Add Student" else "Edit Student",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(fullName, { fullName = it }, label = { Text("Full Name") })
                    OutlinedTextField(dob, { dob = it }, label = { Text("DOB") })
                    OutlinedTextField(age, { age = it }, label = { Text("Age") })

                    Text("Gender")
                    Row {
                        listOf("Male", "Female", "Other").forEach {
                            FilterChip(
                                selected = gender == it,
                                onClick = { gender = it },
                                label = { Text(it) },
                                modifier = Modifier.padding(end = 6.dp)
                            )
                        }
                    }

                    OutlinedTextField(grade, { grade = it }, label = { Text("Grade") })
                    OutlinedTextField(schoolName, { schoolName = it }, label = { Text("School Name") })
                    OutlinedTextField(address, { address = it }, label = { Text("Address") })
                    OutlinedTextField(phone, { phone = it }, label = { Text("Phone") })
                    OutlinedTextField(email, { email = it }, label = { Text("Email") })
                }
            }
        )
    }
}

private fun clearForm(onClear: () -> Unit) {
    onClear()
}
