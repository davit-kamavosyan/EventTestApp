package xyz.davitkamavosyan.app.domain.mapper

import xyz.davitkamavosyan.app.data.local.entity.EventEntity
import xyz.davitkamavosyan.app.domain.model.Event

class EventMapper : (EventEntity) -> Event {
    override fun invoke(item: EventEntity) = Event(
        id = item.id,
        name = item.name,
        description = item.description,
        date = item.date,
        city = item.city,
        address = item.address,
        status = item.status,
        weatherDegreeInCelsius = item.weatherDegreeInCelsius,
        weatherImageUrl = item.weatherImageUrl
    )
}