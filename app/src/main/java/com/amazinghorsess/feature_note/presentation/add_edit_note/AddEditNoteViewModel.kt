package com.amazinghorsess.feature_note.presentation.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.amazinghorsess.feature_note.domain.model.Note
import com.amazinghorsess.feature_note.domain.use_case.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase,
) : ViewModel() {

    private val _noteTitle = mutableStateOf(NoteTextFieldState())
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState())
    val noteContent: State<NoteTextFieldState> = _noteTitle

    private val _noteColor = mutableStateOf(Note.noteColors.random().toArgb())
    val noteColor: State<NoteTextFieldState> = _noteTitle
}