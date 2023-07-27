package com.example.composeProject.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composeProject.ui.theme.fabBackgroundColor
import com.example.composeProject.ui.viewmodels.SharedViewModel
import com.example.composeProject.util.SearchAppBarState
import com.example.myfirstandroidproject.R

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true){
        /*Log.d("ListScreen", "LaunchedEffect Triggered!")*/
        sharedViewModel.getAllTasks()
    }

    val action by sharedViewModel.action

    val allTasks by sharedViewModel.allTasks.collectAsState()
   /* for(task in allTasks.value){
       Log.d("ListScreen", task.title)
    }*/
    val searchAppBarState: SearchAppBarState
    by sharedViewModel.searchAppBarState

    val searchTextState: String by sharedViewModel.searchTextState

    sharedViewModel.handleDatabaseActions(action = action)

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            val appBarHeight = 5.dp
                  ListContent(
                      tasks = allTasks,
                      navigateToTaskScreen = navigateToTaskScreen,
                      appBarHeight = appBarHeight
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_button
            ),
            tint = Color.White
        )
    }
}