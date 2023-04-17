package com.amazinghorsess.feature_note.data.data_source

import androidx.room.*
import com.amazinghorsess.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @androidx.room.Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

    @androidx.room.Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNotesById(id : Int) : Note?

    @androidx.room.Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @androidx.room.Delete
    suspend fun deleteNote(note: Note)

}