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

    var showForm by remember { mutableStateOf(false) }
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
        it.fullName.contains(searchQuery, ignoreCase = true) ||
                it.grade.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        floatingActionButton = {
            if (!showForm) {
                FloatingActionButton(
                    onClick = {
                        editIndex = null
                        showForm = true
                    }
                ) {
                    Text("+")
                }
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            if (showForm) {

                // ===== FORM =====
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = if (editIndex == null) "Add Student" else "Edit Student",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(fullName, { fullName = it }, label = { Text("Full Name") })
                    OutlinedTextField(dob, { dob = it }, label = { Text("Date of Birth") })
                    OutlinedTextField(age, { age = it }, label = { Text("Age") })

                    Text("Gender")
                    Row {
                        listOf("Male", "Female", "Other").forEach {
                            FilterChip(
                                selected = gender == it,
                                onClick = { gender = it },
                                label = { Text(it) },
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }

                    OutlinedTextField(grade, { grade = it }, label = { Text("Grade / Class") })
                    OutlinedTextField(schoolName, { schoolName = it }, label = { Text("School Name") })
                    OutlinedTextField(address, { address = it }, label = { Text("Address") })
                    OutlinedTextField(phone, { phone = it }, label = { Text("Phone Number") })
                    OutlinedTextField(email, { email = it }, label = { Text("Email Address") })

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
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

                            // Reset
                            fullName = ""
                            dob = ""
                            age = ""
                            grade = ""
                            schoolName = ""
                            address = ""
                            phone = ""
                            email = ""
                            gender = "Male"
                            editIndex = null
                            showForm = false
                        }
                    ) {
                        Text("Save")
                    }
                }

            } else {

                // ===== LIST + SEARCH =====
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    Text(
                        text = "Students",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Search students") },
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
                                                showForm = true
                                            }
                                        ) {

                                        }

                                        IconButton(
                                            onClick = {
                                                students = students.toMutableList().also {
                                                    it.removeAt(index)
                                                }
                                            }
                                        ) {

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
}
