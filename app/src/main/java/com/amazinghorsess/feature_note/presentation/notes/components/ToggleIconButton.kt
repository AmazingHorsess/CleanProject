package com.amazinghorsess.feature_note.presentation.notes.components

import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ToggleIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    alternativeIcon: @Composable () -> Unit
) {
    var isToggled by remember { mutableStateOf(false) }

    IconButton(
        modifier = modifier,
        onClick = {
            isToggled = !isToggled
            onClick()
        }
    ) {
        if (isToggled) {
            alternativeIcon()
        } else {
            icon()
        }
    }
}