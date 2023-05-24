package com.amazinghorsess.feature_note.presentation.notes

import com.amazinghorsess.feature_note.domain.model.Note
import com.amazinghorsess.utils.NoteOrder
import com.amazinghorsess.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val notesOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
    val isGrid: Boolean = true,
    val isToggledButton: Boolean = true
    )
