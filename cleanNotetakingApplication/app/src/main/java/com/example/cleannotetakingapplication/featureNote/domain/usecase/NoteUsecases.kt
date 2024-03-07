package com.example.cleannotetakingapplication.featureNote.domain.usecase

data class NoteUsecases(
    val getNotesUsecase: GetNotesUsecase,
    val deleteUsecase: DeleteUsecase
)

// user switch
// in the aosp code
// user and accounts/ multiple users/ add etc...