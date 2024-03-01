package com.example.cleannotetakingapplication.featureNote.data.repository

import com.example.cleannotetakingapplication.featureNote.data.dataSource.NoteDao
import com.example.cleannotetakingapplication.featureNote.domain.model.Note
import com.example.cleannotetakingapplication.featureNote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
        return dao.deleteNOte(note)
    }
}