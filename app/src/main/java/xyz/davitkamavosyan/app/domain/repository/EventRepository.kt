package xyz.davitkamavosyan.app.domain.repository

import kotlinx.coroutines.flow.Flow
import xyz.davitkamavosyan.app.data.local.dao.EventDao
import xyz.davitkamavosyan.app.data.local.entity.EventEntity
import java.util.*

class EventRepository(private val eventDao: EventDao) {

    fun subscribeToEvents() = eventDao.getEventList()

    fun deleteElementById(id: Long) {
        eventDao.deleteEventById(id = id)
    }

    fun getEvent(id: Long): Flow<EventEntity> {
        return eventDao.getEventById(id = id)
    }

    fun addOrUpdateElement(
        id: Long?,
        name: String,
        description: String?,
        selectedDate: Date,
        city: String?,
        address: String?,
        degreeInCelsius: String?,
        weatherImageUrl: String?,

        ) {
        val event = EventEntity(
            id = id ?: 0,
            name = name,
            description = description,
            date = selectedDate,
            status = null,
            city = city,
            address = address,
            weatherDegreeInCelsius = degreeInCelsius,
            weatherImageUrl = weatherImageUrl
        )
        eventDao.insertAll(event)
    }
}