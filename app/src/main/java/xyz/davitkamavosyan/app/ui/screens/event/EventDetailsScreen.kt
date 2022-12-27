package xyz.davitkamavosyan.app.ui.screens.event

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.components.toolbar.UIToolbar
import xyz.davitkamavosyan.app.ui.navigation.NavigationViewModel
import xyz.davitkamavosyan.app.ui.screens.addevent.AddEventViewModel
import xyz.davitkamavosyan.app.ui.screens.home.EventItem

@Composable
fun EventDetailsScreen(
    navigationViewModel: NavigationViewModel,
    eventId: Long?,
    viewModel: EventDetailsViewModel = getViewModel(
        parameters = {
            parametersOf(
                eventId
            )
        }
    ),
) {
    val uiState = viewModel.uiState.collectAsState().value
    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                EventDetailsViewModel.Effect.OnBackPressed -> {
                    navigationViewModel.obtainAction(
                        NavigationViewModel.Action.OnBackPressed
                    )
                }
                is EventDetailsViewModel.Effect.OnAddOrEditClick -> {
                    navigationViewModel.obtainAction(
                        NavigationViewModel.Action.NavigateAddEventScreen(effect.eventId)
                    )
                }
            }
        }
    }
    EventDetailsScreenContent(state = uiState, obtainAction = {
        viewModel.obtainAction(it)
    })
}

@Composable
private fun EventDetailsScreenContent(
    state: EventDetailsViewModel.State = EventDetailsViewModel.State(),
    obtainAction: (EventDetailsViewModel.Action) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        UIToolbar(
            onNavigationIconClicked = {
                obtainAction(EventDetailsViewModel.Action.OnBackPressed)
            },
            actionButtonEnabled = false,
            navigationIconResId = R.drawable.ic_baseline_close_24,
            title = stringResource(id = R.string.event_details),
            onActionIconClicked = {},
            actionText = ""
        )
        state.eventItem?.let { item ->
            EventItem(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
                name = item.name,
                description = item.description,
                onEditClick = {
                    obtainAction(EventDetailsViewModel.Action.OnEditEventClick(item.id))
                },
                onDeleteClick = {
                    obtainAction(EventDetailsViewModel.Action.OnDeleteEventClick(item.id))
                })
        }
    }
}
