package xyz.davitkamavosyan.app.ui.navigation

import android.app.Application
import xyz.davitkamavosyan.app.ui.base.BaseViewModel
import xyz.davitkamavosyan.app.ui.base.exhaustive

class NavigationViewModel(
    application: Application
) : BaseViewModel<NavigationViewModel.Action, NavigationViewModel.Effect, NavigationViewModel.State>(
    application = application, initialState = State()
) {
    data class State(
        val empty: String = ""
    )

    sealed class Action {
        object OnBackPressed : Action()
        class NavigateAddEventScreen(val eventId: Long?) : Action()
        class NavigateEventDetailsScreen(val eventId: Long) : Action()

    }

    sealed class Effect {
        object OnBackPressed : Effect()
        class ShowAddEvent(val eventId: Long?) : Effect()
        class ShowEventDetails(val eventId: Long) : Effect()
    }

    override fun handleAction(action: Action) {
        when (action) {
            Action.OnBackPressed -> {
                obtainEffect { Effect.OnBackPressed }
            }
            is Action.NavigateAddEventScreen -> {
                obtainEffect { Effect.ShowAddEvent(eventId = action.eventId) }
            }
            is Action.NavigateEventDetailsScreen -> {
                obtainEffect { Effect.ShowEventDetails(eventId = action.eventId) }
            }
        }.exhaustive
    }
}