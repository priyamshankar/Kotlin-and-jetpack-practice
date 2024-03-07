package com.example.cleannotetakingapplication.featureNote.domain.usecase

import com.example.cleannotetakingapplication.featureNote.domain.model.Note
import com.example.cleannotetakingapplication.featureNote.domain.repository.NoteRepository

class DeleteUsecase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke (note: Note){
        repository.deleteNote(note)
    }
}