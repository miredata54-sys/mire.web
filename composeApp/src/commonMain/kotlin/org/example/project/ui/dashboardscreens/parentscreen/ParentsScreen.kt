package org.example.project.ui.dashboardscreens.parentscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mire_data_app.composeapp.generated.resources.Res
import mire_data_app.composeapp.generated.resources.deleta
import mire_data_app.composeapp.generated.resources.edit_
import org.example.project.components.MainContentArea
import org.example.project.ui.Parent
import org.jetbrains.compose.resources.painterResource


@Composable
fun ParentsScreen() {

    var parents by remember { mutableStateOf(listOf<Parent>()) }
    var showDialog by remember { mutableStateOf(false) }
    var editIndex by remember { mutableStateOf<Int?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    // Form state
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var studentName by remember { mutableStateOf("") }

    val filteredParents = parents.filter {
        it.name.contains(searchQuery, true) ||
                it.studentName.contains(searchQuery, true)
    }

    MainContentArea(title = "Parents") {

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
                    text = "Parents Management",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = {
                        editIndex = null
                        clearParentForm {
                            name = ""
                            phone = ""
                            email = ""
                            studentName = ""
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
                label = { Text("Search parents") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (filteredParents.isEmpty()) {
                Text("No parents found", color = Color.Gray)
            } else {
                filteredParents.forEachIndexed { index, parent ->
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
                                Text(parent.name, fontWeight = FontWeight.Bold)
                                Text("Student: ${parent.studentName}")
                                Text("Phone: ${parent.phone}")
                            }

                            Row {
                                IconButton(
                                    onClick = {
                                        editIndex = index
                                        name = parent.name
                                        phone = parent.phone
                                        email = parent.email
                                        studentName = parent.studentName
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
                                        parents = parents.toMutableList().also {
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

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(
                    onClick = {
                        val parent = Parent(name, phone, email, studentName)

                        parents =
                            if (editIndex == null) {
                                parents + parent
                            } else {
                                parents.toMutableList().also {
                                    it[editIndex!!] = parent
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
                    text = if (editIndex == null) "Add Parent" else "Edit Parent",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(name, { name = it }, label = { Text("Parent Name") })
                    OutlinedTextField(phone, { phone = it }, label = { Text("Phone Number") })
                    OutlinedTextField(email, { email = it }, label = { Text("Email Address") })
                    OutlinedTextField(studentName, { studentName = it }, label = { Text("Student Name") })
                }
            }
        )
    }
}

private fun clearParentForm(onClear: () -> Unit) {
    onClear()
}
