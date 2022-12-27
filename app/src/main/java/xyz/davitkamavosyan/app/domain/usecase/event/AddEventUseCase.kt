package xyz.davitkamavosyan.app.domain.usecase.event

import xyz.davitkamavosyan.app.domain.repository.EventRepository
import java.util.*

class AddEventUseCase(
    private val eventRepository: EventRepository,
) {
    suspend operator fun invoke(
        id: Long?,
        name: String,
        description: String?,
        selectedDate: Date,
        city: String?,
        address: String?,
        degreeInCelsius: String?,
        weatherImageUrl: String?,
    ) {
        return eventRepository.addOrUpdateElement(
            id = id,
            name = name,
            description = description,
            selectedDate = selectedDate,
            city = city,
            address = address,
            degreeInCelsius = degreeInCelsius,
            weatherImageUrl = weatherImageUrl,
        )

    }
}