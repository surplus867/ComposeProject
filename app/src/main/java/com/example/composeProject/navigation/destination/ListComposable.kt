package com.example.composeProject.navigation.destination

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeProject.ui.screens.list.ListScreen
import com.example.composeProject.ui.viewmodels.SharedViewModel
import com.example.composeProject.util.Constants.LIST_ARGUMENT_KEY
import com.example.composeProject.util.Constants.LIST_SCREEN
import com.example.composeProject.util.toAction

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY)?.toAction()

        LaunchedEffect(key1 = action) {
            if (action != null) {
                sharedViewModel.action.value = action
            }
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}