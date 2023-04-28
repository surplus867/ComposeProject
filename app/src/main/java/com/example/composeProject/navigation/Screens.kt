package com.example.composeProject.navigation

import androidx.navigation.NavHostController
import com.example.composeProject.util.Action
import com.example.composeProject.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route ="task/$taskId")
    }
}