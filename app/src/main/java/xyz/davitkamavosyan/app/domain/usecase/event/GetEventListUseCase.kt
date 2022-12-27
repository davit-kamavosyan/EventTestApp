package xyz.davitkamavosyan.app.domain.usecase.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.davitkamavosyan.app.data.local.entity.EventEntity
import xyz.davitkamavosyan.app.domain.model.Event
import xyz.davitkamavosyan.app.domain.repository.EventRepository

class GetEventListUseCase(
    private val eventRepository: EventRepository,
    private val mapper: (EventEntity) -> Event
) {
    suspend operator fun invoke(): Flow<List<Event>> {
        return eventRepository.subscribeToEvents().map {
            it.map(mapper)
        }
    }
}