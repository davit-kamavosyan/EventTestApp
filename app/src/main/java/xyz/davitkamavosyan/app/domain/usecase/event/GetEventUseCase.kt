package xyz.davitkamavosyan.app.domain.usecase.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.davitkamavosyan.app.data.local.entity.EventEntity
import xyz.davitkamavosyan.app.domain.model.Event
import xyz.davitkamavosyan.app.domain.repository.EventRepository

class GetEventUseCase(
    private val eventRepository: EventRepository,
    private val mapper: (EventEntity) -> Event
) {
    suspend operator fun invoke(id: Long): Flow<Event> {
        return eventRepository.getEvent(id).map(mapper)
    }
}