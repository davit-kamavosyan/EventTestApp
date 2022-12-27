package xyz.davitkamavosyan.app.domain.usecase.event

import xyz.davitkamavosyan.app.domain.repository.EventRepository

class DeleteEventUseCase(
    private val eventRepository: EventRepository,
) {
    suspend operator fun invoke(eventId: Long) {
        eventRepository.deleteElementById(eventId)
    }
}