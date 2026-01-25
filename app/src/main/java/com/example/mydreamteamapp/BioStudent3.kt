package com.example.mydreamteamapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentThree(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bermas", color = Color(0xFF3E2F1C)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF3E2F1C)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6B8E23),
                    titleContentColor = Color(0xFF3E2F1C)
                )
            )
        },
        containerColor = Color(0xFFECE1D6)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .verticalScroll(rememberScrollState())
                    .background(Color(0xFFDDB892), RoundedCornerShape(24.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.bermas),
                    contentDescription = "John Carlo Bermas",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .shadow(4.dp, CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "John Carlo Bermas",
                    fontSize = 25.sp,
                    color = Color(0xFF3E2F1C)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "BSIT 3A | Student 3",
                    fontSize = 13.sp,
                    color = Color(0xFF3E2F1C)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "An IT student passionate about mobile application development and exploring new software architectures.",
                    fontSize = 15.sp,
                    color = Color(0xFF3E2F1C),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}