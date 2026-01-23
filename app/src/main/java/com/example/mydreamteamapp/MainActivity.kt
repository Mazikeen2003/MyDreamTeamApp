package com.example.mydreamteamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mydreamteamapp.StudentOne
import com.example.mydreamteamapp.StudentTwo
import com.example.mydreamteamapp.StudentThree
import com.example.mydreamteamapp.StudentFour
import com.example.mydreamteamapp.StudentFive

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "main_buttons",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFECE1D6))
            ) {
                composable("main_buttons") { MainScreen(navController) }
                composable("student_one") { StudentOne(navController) }
                composable("student_two") { StudentTwo(navController) }
                composable("student_three") { StudentThree(navController) }
                composable("student_four") { StudentFour(navController) }
                composable("student_five") { StudentFive(navController) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val backgroundColor = Color(0xFFECE1D6)
    val topBarColor = Color(0xFF6B8E23)
    val topBarText = Color(0xFF3E2F1C)
    val containerColor = Color(0xFFDDB892)
    val buttonColor = Color(0xFF8FBC8F)
    val buttonTextColor = Color(0xFF3E2F1C)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Dream Team", color = topBarText) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarColor,
                    titleContentColor = topBarText
                )
            )
        },
        containerColor = backgroundColor
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .heightIn(min = 500.dp, max = 600.dp)
                    .fillMaxWidth(0.9f)
                    .background(containerColor, RoundedCornerShape(24.dp))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val buttonShape = RoundedCornerShape(12.dp)
                    val buttonModifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .shadow(4.dp, buttonShape)

                    StudentButton("Student One", navController, "student_one", buttonColor, buttonTextColor, buttonShape, buttonModifier)
                    StudentButton("Student Two", navController, "student_two", buttonColor, buttonTextColor, buttonShape, buttonModifier)
                    StudentButton("Student Three", navController, "student_three", buttonColor, buttonTextColor, buttonShape, buttonModifier)
                    StudentButton("Student Four", navController, "student_four", buttonColor, buttonTextColor, buttonShape, buttonModifier)
                    StudentButton("Student Five", navController, "student_five", buttonColor, buttonTextColor, buttonShape, buttonModifier)
                }
            }
        }
    }
}

@Composable
fun StudentButton(
    label: String,
    navController: NavController,
    route: String,
    containerColor: Color,
    contentColor: Color,
    shape: RoundedCornerShape,
    modifier: Modifier
) {
    Button(
        onClick = { navController.navigate(route) },
        colors = ButtonDefaults.buttonColors(containerColor = containerColor, contentColor = contentColor),
        shape = shape,
        modifier = modifier
    ) {
        Text(label, fontSize = 18.sp)
    }
}


