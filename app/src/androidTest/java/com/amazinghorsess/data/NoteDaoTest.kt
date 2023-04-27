package com.amazinghorsess.data

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.amazinghorsess.feature_note.data.data_source.NoteDao
import com.amazinghorsess.feature_note.data.data_source.NoteDatabase
import com.amazinghorsess.feature_note.domain.model.Note

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class NoteDaoTest {

    private lateinit var sut: NoteDao
    private lateinit var mDb: NoteDatabase

    @Before
    fun createDb() {

        mDb = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            NoteDatabase::class.java
        ).allowMainThreadQueries().build()
        sut = mDb.noteDao

        @After
        fun closeDb() {
            mDb.close()
        }

        @Test
        fun testInsertNoteAndReadInList() = runBlocking {
            // arrange
            val fakeText = "some text"
            val fakeNote = Note(title = "some text", content = "content test", timestamp = 232, color = 3)

            // act
            sut.insertNote(fakeNote)
            val noteList = sut.getAllNotes().first()

            // assert
            assertThat(noteList.first().title).isEqualTo(fakeText)
        }



        @Test
        fun testDeleteNoteRemovesNoteFromList() = runBlocking {
            // arrange
            val fakeText = "some text"
            val fakeNote = Note(title = "some text", content = "content test", timestamp = 232, color = 3)

            // act
            sut.insertNote(fakeNote)
            val noteList = sut.getAllNotes().first()
            sut.deleteNote(noteList.first())
            val noteListUpdated = sut.getAllNotes().first()

            // assert
            assert(noteListUpdated).isEmpty()
        }
    }

    }
