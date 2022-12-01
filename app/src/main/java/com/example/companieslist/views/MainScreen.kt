package com.example.companieslist.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.companieslist.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(
                navController = navController
            )
        }
    }
}