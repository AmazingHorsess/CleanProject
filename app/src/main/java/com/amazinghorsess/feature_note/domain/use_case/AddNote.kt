package com.amazinghorsess.feature_note.domain.use_case

import com.amazinghorsess.feature_note.domain.model.InvalidNoteException
import com.amazinghorsess.feature_note.domain.model.Note
import com.amazinghorsess.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

    class AddNote(
        private val repository: NoteRepository
        ) {
        @Throws(InvalidNoteException::class)
        suspend operator fun invoke(note: Note) {
            if (note.title.isBlank()){
                throw InvalidNoteException("The title of the note can't be empty.")

            }
            val content = if (note.content.isBlank()) "No text" else note.content
            val updatedNote = note.copy(content = content)
            repository.insertNote(updatedNote)
            repository.insertNote(note)
        }

    }