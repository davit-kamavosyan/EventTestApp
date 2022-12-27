package xyz.davitkamavosyan.app.domain.model

import java.util.*

data class Event(
    val id: Long,
    val name: String,
    val description: String?,
    val date: Date,
    val status: String?,
    val address: String?,
    val city: String?,
    val weatherDegreeInCelsius:String?,
    val weatherImageUrl:String?
)