package xyz.davitkamavosyan.app.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.settlo.inventories.ui.components.line.HorizontalLine
import io.settlo.inventories.ui.components.screen.EmptyScreenContent
import org.koin.androidx.compose.getViewModel
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.components.Weather
import xyz.davitkamavosyan.app.ui.components.action.UiActionItem
import xyz.davitkamavosyan.app.ui.components.text.TextSubtitle3
import xyz.davitkamavosyan.app.ui.components.text.TextTitle3
import xyz.davitkamavosyan.app.ui.components.toolbar.UIToolbar
import xyz.davitkamavosyan.app.ui.navigation.NavigationViewModel

@Composable
fun HomeScreen(
    navigationViewModel: NavigationViewModel,
    viewModel: HomeViewModel = getViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState().value
    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeViewModel.Effect.OnAddOrEditClick -> {
                    navigationViewModel.obtainAction(
                        NavigationViewModel.Action.NavigateAddEventScreen(
                            eventId = effect.eventId
                        )
                    )
                }
                is HomeViewModel.Effect.OnItemClick -> {
                    navigationViewModel.obtainAction(
                        NavigationViewModel.Action.NavigateEventDetailsScreen(
                            eventId = effect.eventId
                        )
                    )
                }
                is HomeViewModel.Effect.ShowEventDetails -> {
                    navigationViewModel.obtainAction(
                        NavigationViewModel.Action.NavigateEventDetailsScreen(
                            eventId = effect.eventId
                        )
                    )
                }
            }
        }
    }
    HomeScreenContent(state = uiState, obtainAction = {
        viewModel.obtainAction(it)
    })
}

@Composable
private fun HomeScreenContent(
    state: HomeViewModel.State = HomeViewModel.State(),
    obtainAction: (HomeViewModel.Action) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        UIToolbar(
            onNavigationIconClicked = {},
            actionButtonEnabled = true,
            onActionIconClicked = {
                obtainAction(HomeViewModel.Action.OnAddEventClick)
            },
            navigationIconResId = null,
            title = stringResource(id = R.string.home),
            actionText = stringResource(id = R.string.add_event)
        )
        if (state.loading) {
            // todo show loading
        } else {
            if (state.itemList.isEmpty()) {
                HomeEmptyScreen {
                    obtainAction(HomeViewModel.Action.OnAddEventClick)
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(
                        vertical = 16.dp
                    )
                ) {
                    items(state.itemList) { item ->
                        EventItem(modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            name = item.name,
                            description = item.description,
                            onEditClick = {
                                obtainAction(HomeViewModel.Action.OnEditEventClick(item.id))
                            },
                            onDeleteClick = {
                                obtainAction(HomeViewModel.Action.OnDeleteEventClick(item.id))
                            },
                            onItemClick = {
                                obtainAction(HomeViewModel.Action.OnEventItemClick(item.id))
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeEmptyScreen(onAddClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        EmptyScreenContent(
            iconResId = R.drawable.ic_baseline_event_24,
            title = stringResource(R.string.event),
            description = stringResource(id = R.string.please_add_event),
            buttonText = stringResource(id = R.string.add_event),
            buttonIconResId = R.drawable.ic_baseline_add_24,
            onClick = onAddClick
        )
    }
}

@Preview
@Composable
fun EventItem(
    modifier: Modifier = Modifier,
    name: String = "name",
    description: String? = "description",
    city: String? = "city",
    address: String? = "address",
    weatherImageUrl: String? = "",
    weatherDegreeInCelsius: String? = "",
    onEditClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onItemClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clickable { onItemClick() },
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextTitle3(text = name)
                UiActionItem(
                    onEditClick = onEditClick, onDeleteClick = onDeleteClick
                )
            }
            HorizontalLine(
                modifier = Modifier
                    .fillMaxWidth()
            )
            Weather(
                modifier = Modifier.fillMaxWidth(),
                imageUrl = weatherImageUrl,
                degreeInCelsius = weatherDegreeInCelsius
            )
            description?.let {
                TextSubtitle3(text = description)
            }
            city?.let {
                TextSubtitle3(text = city)
            }
            address?.let {
                TextSubtitle3(text = address)
            }
        }
    }
}
