package com.example.composeProject.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeProject.ui.screens.list.ListScreen
import com.example.composeProject.ui.viewmodels.SharedViewModel
import com.example.composeProject.util.Action
import com.example.composeProject.util.Constants.LIST_ARGUMENT_KEY
import com.example.composeProject.util.Constants.LIST_SCREEN
import com.example.composeProject.util.toAction

@OptIn(ExperimentalAnimationApi::class)
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

        var myAction by rememberSaveable { mutableStateOf<Action?>(null) }

        if (action != null && myAction != action) {
            myAction = action
            LaunchedEffect(key1 = action) {
                sharedViewModel.updateAction(newAction = action)
            }
        }

        val databaseAction = sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}