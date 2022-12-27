package xyz.davitkamavosyan.app.ui.screens.addevent

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.base.exhaustive
import xyz.davitkamavosyan.app.ui.components.Weather
import xyz.davitkamavosyan.app.ui.components.text.TextTitle3
import xyz.davitkamavosyan.app.ui.components.textfield.UITextFieldItem
import xyz.davitkamavosyan.app.ui.components.textfield.UiClickableTextFieldItem
import xyz.davitkamavosyan.app.ui.components.toolbar.UIToolbar
import xyz.davitkamavosyan.app.ui.navigation.NavigationViewModel
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun AddEventScreen(
    navigationViewModel: NavigationViewModel,
    eventId: Long? = null,
    viewModel: AddEventViewModel = getViewModel(
        parameters = {
            parametersOf(
                eventId
            )
        }
    ),
) {
    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                AddEventViewModel.Effect.OnBackPressed -> {
                    navigationViewModel.obtainAction(NavigationViewModel.Action.OnBackPressed)
                }
            }.exhaustive
        }
    }
    val uiState = viewModel.uiState.collectAsState().value
    AddEventScreenContent(
        state = uiState,
        obtainAction = {
            viewModel.obtainAction(it)
        }
    )
}


@Preview
@Composable
private fun AddEventScreenContent(
    state: AddEventViewModel.State = AddEventViewModel.State(),
    obtainAction: (AddEventViewModel.Action) -> Unit = {}
) {
    Column(Modifier.fillMaxSize()) {
        UIToolbar(
            navigationIconResId = R.drawable.ic_baseline_close_24,
            onNavigationIconClicked = {
                obtainAction(AddEventViewModel.Action.OnBackPressed)
            },
            actionButtonEnabled = true,
            onActionIconClicked = {
                obtainAction(AddEventViewModel.Action.OnContinueClick)
            },
            actionText = stringResource(R.string.button_continue),
            title = if (state.isNewEvent) {
                stringResource(id = R.string.add_event)
            } else {
                stringResource(id = R.string.update_event)
            }
        )
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                vertical = 16.dp
            )
        ) {
            item {
                Step1(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    state = state,
                    obtainAction = obtainAction
                )
            }
            item {
                Step2(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    state = state,
                    obtainAction = obtainAction
                )
            }
        }
    }
}

@Preview
@Composable
fun Step1(
    modifier: Modifier = Modifier,
    state: AddEventViewModel.State = AddEventViewModel.State(),
    obtainAction: (AddEventViewModel.Action) -> Unit = {}
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextTitle3(text = stringResource(R.string.add_name_and_description))
            UITextFieldItem(
                item = state.name,
                onValueChange = {
                    obtainAction(AddEventViewModel.Action.OnNameChange(it))
                })
            UITextFieldItem(
                item = state.description, onValueChange = {
                    obtainAction(AddEventViewModel.Action.OnDescriptionChange(it))
                })
        }
    }
}

@Preview
@Composable
fun Step2(
    modifier: Modifier = Modifier,
    state: AddEventViewModel.State = AddEventViewModel.State(),
    obtainAction: (AddEventViewModel.Action) -> Unit = {}
) {
    val time = LocalTime.now()
    val date = LocalDate.now()

    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _, hour, minute ->
            obtainAction(
                AddEventViewModel.Action.OnTimeSelect(
                    hour = hour, minute = minute
                )
            )
        },
        time.hour,
        time.minute,
        true,
    )
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            obtainAction(
                AddEventViewModel.Action.OnDateSelect(
                    year = year, month = month, day = dayOfMonth
                )
            )
        },
        date.year,
        date.monthValue - 1,
        date.dayOfMonth,
    )

    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextTitle3(text = stringResource(R.string.add_place_and_date))
            Weather(
                imageUrl = state.currentWeatherImageUrl,
                degreeInCelsius = state.currentWeatherDegreeInCelsius
            )
            UITextFieldItem(
                item = state.city,
                onValueChange = {
                    obtainAction(AddEventViewModel.Action.OnCityValueChange(it))
                })
            UITextFieldItem(
                item = state.address,
                onValueChange = {
                    obtainAction(AddEventViewModel.Action.OnAddressValueChange(it))
                })
            UiClickableTextFieldItem(
                item = state.date,
                onClick = {
                    datePickerDialog.show()
                },
                readOnly = true
            )
            UiClickableTextFieldItem(
                item = state.time,
                readOnly = true,
                onClick = {
                    timePickerDialog.show()
                }
            )
        }
    }
}