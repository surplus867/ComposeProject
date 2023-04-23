package com.example.composeProject.data.models

import androidx.compose.ui.graphics.Color
import com.example.composeProject.ui.theme.HighPriorityColor
import com.example.composeProject.ui.theme.LowPriorityColor
import com.example.composeProject.ui.theme.MediumPriorityColor
import com.example.composeProject.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}