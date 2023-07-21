package com.example.composeProject.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeProject.data.models.Priority
import com.example.composeProject.data.models.ToDoTask
import com.example.composeProject.ui.screens.task.TaskAppBar
import com.example.composeProject.ui.screens.task.TaskContent
import com.example.composeProject.util.Action

val AppBarHeight = 56.dp
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
){

    Scaffold(
        topBar = {
                 TaskAppBar(
                     selectedTask = selectedTask,
                     navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            Surface(
                modifier =
                Modifier.fillMaxSize()
                    .padding(top = AppBarHeight)
            ) {
                TaskContent(
                    title = selectedTask?.title ?: "",
                    onTitleChange = {},
                    description = "",
                    onDescriptionChange = {},
                    priority = Priority.LOW,
                    onPrioritySelected = {}
                )
            }
        }
    )
}