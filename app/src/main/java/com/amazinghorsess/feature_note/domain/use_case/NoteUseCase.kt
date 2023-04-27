package com.amazinghorsess.feature_note.domain.use_case

data class NoteUseCase (
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val getNote: GetNote,
    val addNote: AddNote
        )