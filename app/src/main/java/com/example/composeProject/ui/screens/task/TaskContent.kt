package com.example.composeProject.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeProject.components.PriorityDropDown
import com.example.composeProject.data.models.Priority
import com.example.composeProject.ui.theme.LARGE_PADDING
import com.example.composeProject.ui.theme.MEDIUM_PADDING
import com.example.myfirstandroidproject.R

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING)
    ) {
        // Title TextField
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING), // Add some padding to the bottom of the title field
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(id = R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        // Priority Dropdown
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )

        // Description TextField
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(id = R.string.description)) },
            textStyle = MaterialTheme.typography.body1,
        )
    }
}

@Composable
@Preview
private fun TaskContentPreview(){
    TaskContent(
        title = "",
        onTitleChange = {} ,
        description = "",
        onDescriptionChange = {} ,
        priority = Priority.LOW,
        onPrioritySelected = {},
    )
}