package com.example.cleannotetakingapplication.featureNote.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleannotetakingapplication.featureNote.domain.model.Note


@Database(
    entities = [Note :: class],
    version = 1
)
abstract class NoteDatabase :RoomDatabase(){
    abstract val noteDao : NoteDao
}