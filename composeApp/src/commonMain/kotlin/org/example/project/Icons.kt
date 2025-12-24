package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import mire_data_app.composeapp.generated.resources.Res
import mire_data_app.composeapp.generated.resources.coat_of_arms_of_somalia_1__1_
import mire_data_app.composeapp.generated.resources.graduation_cap
import mire_data_app.composeapp.generated.resources.parents
import mire_data_app.composeapp.generated.resources.schools
import mire_data_app.composeapp.generated.resources.student
import mire_data_app.composeapp.generated.resources.teachers

@Composable
fun PersonIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
            contentDescription = "Person Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun PadlockIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
            contentDescription = "Padlock Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun EducationIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .background(Color.White), // Background cadaan
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
            contentDescription = "Education Icon",
            modifier = Modifier.size(70.dp)
        )
    }
}

//dashboard image
@Composable
fun SchoolIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.schools),
            contentDescription = "School Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun GraduationCapIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.student),
            contentDescription = "Graduation Cap Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun TeachersIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.teachers),
            contentDescription = "Teachers Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ParentsIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.parents),
            contentDescription = "Parents Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
            contentDescription = "Search Icon",
            modifier = Modifier.size(32.dp)
        )
    }
}
