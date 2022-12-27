package xyz.davitkamavosyan.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String?,
    val date: Date,
    val status: String?,
    val address: String?,
    val city: String?,
    val weatherDegreeInCelsius: String?,
    val weatherImageUrl: String?
)
