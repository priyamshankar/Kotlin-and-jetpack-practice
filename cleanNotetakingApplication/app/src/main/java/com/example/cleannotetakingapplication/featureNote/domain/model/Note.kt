package com.example.cleannotetakingapplication.featureNote.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity

@Entity
data class Note(
    val title: String, val content: String, val timeStamp: Long, val color: Int
) {
    companion object {
        val noteColors = listOf(
            Color(red = 1, blue = 5, green = 8),
            Color(red = 10, blue = 50, green = 18),
            Color(red = 14, blue = 35, green = 58),
            Color(red = 1, blue = 15, green = 81)
        )
    }

}