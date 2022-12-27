package xyz.davitkamavosyan.app.ui.screens.event

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.davitkamavosyan.app.domain.model.Event
import xyz.davitkamavosyan.app.domain.usecase.event.DeleteEventUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.GetEventUseCase
import xyz.davitkamavosyan.app.ui.base.BaseViewModel
import xyz.davitkamavosyan.app.ui.base.exhaustive

class EventDetailsViewModel(
    application: Application,
    private val getEventUseCase: GetEventUseCase,
    val deleteEventUseCase: DeleteEventUseCase,
    private val eventId: Long,
) : BaseViewModel<EventDetailsViewModel.Action, EventDetailsViewModel.Effect, EventDetailsViewModel.State>(
    application = application, initialState = State()
) {
    data class State(
        val eventItem: Event? = null
    )

    sealed class Action {
        object OnBackPressed : Action()
        class OnEditEventClick(val eventId: Long) : Action()
        class OnDeleteEventClick(val eventId: Long) : Action()
    }

    sealed class Effect {
        class OnAddOrEditClick(val eventId: Long?) : Effect()
        object OnBackPressed : Effect()
    }

    override fun handleAction(action: Action) {
        when (action) {
            Action.OnBackPressed -> {
                obtainEffect { Effect.OnBackPressed }
            }
            is Action.OnEditEventClick -> {
                obtainEffect { Effect.OnAddOrEditClick(action.eventId) }
            }
            is Action.OnDeleteEventClick -> {
                onDeleteEvent(action.eventId)
            }
        }.exhaustive
    }

    private fun onDeleteEvent(eventId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteEventUseCase(eventId)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getEventUseCase(eventId).collectLatest { event ->
                obtainState {
                    copy(
                        eventItem = event
                    )
                }
            }
        }
    }
}
