package xyz.davitkamavosyan.app.ui.screens.home

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.davitkamavosyan.app.domain.model.Event
import xyz.davitkamavosyan.app.domain.usecase.event.DeleteEventUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.GetEventListUseCase
import xyz.davitkamavosyan.app.ui.base.BaseViewModel
import xyz.davitkamavosyan.app.ui.base.exhaustive

class HomeViewModel(
    application: Application,
    val getEventListUseCase: GetEventListUseCase,
    val deleteEventUseCase: DeleteEventUseCase,
) : BaseViewModel<HomeViewModel.Action, HomeViewModel.Effect, HomeViewModel.State>(
    application = application,
    initialState = State()
) {
    data class State(
        val loading: Boolean = true,
        val itemList: List<Event> = ArrayList()
    )

    sealed class Action {
        class OnEditEventClick(val eventId: Long) : Action()
        class OnDeleteEventClick(val eventId: Long) : Action()
        object OnAddEventClick : Action()
        class OnItemClick(val eventId: Long) : Action()
        class OnEventItemClick(val eventId: Long) : Action()
    }

    sealed class Effect {
        class OnAddOrEditClick(val eventId: Long?) : Effect()
        class ShowEventDetails(val eventId: Long) : Effect()
        class OnItemClick(val eventId: Long) : Effect()
    }

    override fun handleAction(action: Action) {
        when (action) {
            Action.OnAddEventClick -> {
                obtainEffect { Effect.OnAddOrEditClick(eventId = null) }
            }
            is Action.OnItemClick -> {
                obtainEffect { Effect.OnItemClick(action.eventId) }
            }
            is Action.OnEditEventClick -> {
                obtainEffect { Effect.OnAddOrEditClick(action.eventId) }
            }
            is Action.OnDeleteEventClick -> {
                onDeleteEvent(action.eventId)
            }
            is Action.OnEventItemClick -> {
                obtainEffect { Effect.ShowEventDetails(action.eventId) }
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
            getEventListUseCase().collectLatest { eventList ->
                obtainState {
                    copy(
                        itemList = eventList,
                        loading = false
                    )
                }
            }
        }
    }
}
