package com.example.cleannotetakingapplication.di

import android.app.Application
import androidx.room.Room
import com.example.cleannotetakingapplication.featureNote.data.dataSource.NoteDatabase
import com.example.cleannotetakingapplication.featureNote.data.repository.NoteRepositoryImpl
import com.example.cleannotetakingapplication.featureNote.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase :: class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }
}