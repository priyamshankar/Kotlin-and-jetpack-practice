package com.example.cleannotetakingapplication.featureNote.data.dataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cleannotetakingapplication.featureNote.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note where id = :id")
    suspend fun getNoteById (id:Int):Note?

    @Insert
    fun insertNote(note:Note)

    @Delete
    fun deleteNOte(note:Note)
}