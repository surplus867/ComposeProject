package com.example.composeProject.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
){

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

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
                Modifier.fillMaxSize()
                    .padding(top = AppBarHeight)
            ) {
                TaskContent(
                    title = title,
                    onTitleChange = {
                                    sharedViewModel.updateTitle(it)
                    },
                    description = description,
                    onDescriptionChange = {
                                          sharedViewModel.description.value = it
                    },
                    priority = priority,
                    onPrioritySelected = {
                        sharedViewModel.priority.value = it
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