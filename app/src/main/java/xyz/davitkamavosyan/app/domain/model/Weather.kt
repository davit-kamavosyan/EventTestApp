package xyz.davitkamavosyan.app.domain.model

data class Weather(
    val date: Long,
    val imageUrl: String?,
    val type: String?,
    val degreeInCelsius: String,
)
