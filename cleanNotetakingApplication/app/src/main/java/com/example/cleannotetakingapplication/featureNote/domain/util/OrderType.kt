package com.example.cleannotetakingapplication.featureNote.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}