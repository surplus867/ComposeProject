package com.example.composeProject.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composeProject.data.models.Priority
import com.example.composeProject.data.models.ToDoTask
import com.example.composeProject.ui.screens.task.TaskAppBar
import com.example.composeProject.ui.screens.task.TaskContent
import com.example.composeProject.ui.viewmodels.SharedViewModel
import com.example.composeProject.util.Action

val AppBarHeight = 54.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String =  sharedViewModel.title
    val description: String = sharedViewModel.description
    val priority: Priority = sharedViewModel.priority

    val context = LocalContext.current

    /*BackHandler(onBacPressed = { navigateToListScreen(Action.NO_ACTION) })*/

    BackHandler {
        //Log.d("Back", "Triggered!")
        navigateToListScreen(Action.NO_ACTION)
    }

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                }
            )
        },
        content = {
            Surface(
                modifier =
                Modifier
                    .fillMaxSize()
                    .padding(top = AppBarHeight)
            ) {
                TaskContent(
                    title = title,
                    onTitleChange = {
                        sharedViewModel.updateTitle(it)
                    },
                    description = description,
                    onDescriptionChange = {
                        sharedViewModel.updateDescription(newDescription = it)
                    },
                    priority = priority,
                    onPrioritySelected = {
                        sharedViewModel.updatePriority(newPriority = it)
                    }
                )
            }
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()
}

/*
@Composable
fun BackHandler(
    backDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBacPressed: () -> Unit
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBacPressed)

    val backCallBack = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backDispatcher) {
        backDispatcher?.addCallback(backCallBack)

        onDispose {
            backCallBack.remove()
        }
    }
}*/
