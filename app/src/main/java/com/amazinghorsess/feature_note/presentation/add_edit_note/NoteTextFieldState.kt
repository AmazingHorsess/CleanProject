package com.amazinghorsess.feature_note.presentation.add_edit_note

sealed class NoteTextFieldState (
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
        )

