package com.example.composeProject.navigation

import androidx.navigation.NavController
import com.example.composeProject.util.Action
import com.example.composeProject.util.Constants.LIST_SCREEN

class Screens(navController: NavController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive= true}
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}