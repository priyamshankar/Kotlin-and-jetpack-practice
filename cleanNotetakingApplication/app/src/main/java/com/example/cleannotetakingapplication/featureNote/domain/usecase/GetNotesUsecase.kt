package com.example.cleannotetakingapplication.featureNote.domain.usecase

import com.example.cleannotetakingapplication.featureNote.domain.model.Note
import com.example.cleannotetakingapplication.featureNote.domain.repository.NoteRepository
import com.example.cleannotetakingapplication.featureNote.domain.util.NoteOrder
import com.example.cleannotetakingapplication.featureNote.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUsecase(
    private val repository: NoteRepository
) {
    // there are generally only one public function inside one usecase,
    // also the view modle will call this function with certain requirements like sort by name date ascending or descending that is why
    //basically whoever call the use case should be able to tell somehow to this use case that "hey I want this notes list in this particular order, that is why we are writing the logic in the util package.
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending)
    ) :Flow<List<Note>>{
        return repository.getNotes().map { noteobj ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Date -> noteobj.sortedBy { it.timeStamp }
                        is NoteOrder.Title -> noteobj.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color -> noteobj.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Date -> noteobj.sortedByDescending { it.timeStamp }
                        is NoteOrder.Title -> noteobj.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Color -> noteobj.sortedByDescending { it.color }
                    }
                }

            }
        }
    }
}