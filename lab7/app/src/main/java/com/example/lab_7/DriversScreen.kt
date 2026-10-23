package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember { mutableStateOf("") }
    var drivers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // For testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title Text
        Text(
            text = "Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text field and button to add driver
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driver,
                onValueChange = {
                    driver = it // Update location to new value
                },
                label = {
                    Text("Driver")
                },
                modifier = Modifier.testTag("driverInput") // For testing
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        drivers.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // For testing
            ) {
                Text("Add")
            }

            Button(
                onClick = {
                    if (drivers.isNotEmpty()) {
                        drivers.clear()
                    }
                },
                modifier = Modifier.testTag("clearDriversButton")
            ) {
                Text("Clear all")
            }
        }
    }

    LazyColumn {
        items(drivers) { driver ->
            Spacer(Modifier.height(16.dp))

            Text(
                text = driver,
                fontSize = 24.sp
            )
        }
    }
}