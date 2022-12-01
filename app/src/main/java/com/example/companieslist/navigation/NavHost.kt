package com.example.companieslist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.companieslist.views.CompaniesScreen
import com.example.companieslist.views.DetailsScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "CompaniesList"
    ) {
        composable("CompaniesList") {
            CompaniesScreen(navController)
        }
        composable(
            "Details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString("id"))
        }
    }
}