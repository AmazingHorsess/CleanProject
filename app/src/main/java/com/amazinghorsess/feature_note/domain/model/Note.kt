package com.amazinghorsess.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amazinghorsess.utils.theme.*

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int




) {
    companion object{
        val noteColors = listOf(
            PastelBlue,
            PastelRed,
            PastelPink,
            PastelBeige,
            PastelGreen)
    }
}

class InvalidNoteException(message: String): Exception(message)
