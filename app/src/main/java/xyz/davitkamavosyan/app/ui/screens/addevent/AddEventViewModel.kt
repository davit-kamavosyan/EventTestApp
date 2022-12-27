package xyz.davitkamavosyan.app.ui.screens.addevent

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.domain.usecase.weather.GetWeatherUseCase
import xyz.davitkamavosyan.app.domain.model.Weather
import xyz.davitkamavosyan.app.domain.usecase.event.AddEventUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.GetEventUseCase
import xyz.davitkamavosyan.app.ui.base.BaseViewModel
import xyz.davitkamavosyan.app.ui.base.exhaustive
import xyz.davitkamavosyan.app.ui.base.getNullIfEmpty
import xyz.davitkamavosyan.app.ui.components.textfield.UITextField
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class AddEventViewModel(
    application: Application,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val addEventUseCase: AddEventUseCase,
    private val getEventUseCase: GetEventUseCase,
    private val eventId: Long? = null
) : BaseViewModel<AddEventViewModel.Action, AddEventViewModel.Effect, AddEventViewModel.State>(
    application = application, initialState = State()
) {
    private var checkWeatherJob: Job? = null
//    Приложение Планировщик мероприятий.
//    Возможности:
//    - Добавлять/удалять/редактировать/просматривать мероприятия
//    - Помечать мероприятия как "посещённые" или "пропущенные"
//    - Отображать погоду на назначенную дату в месте проведения мероприятия. Можно использовать любое открытое api (например, https://openweathermap.org)
//    - Изменять иконку в зависимости от погоды
//    - Составляющие мероприятия: название, описание, дата проведения, место проведения (включая город), погода на момент проведения мероприятия

    init {
        if (eventId != null) {
            viewModelScope.launch(Dispatchers.IO) {
                getEventUseCase.invoke(eventId).collectLatest { event ->
                    val calendar = GregorianCalendar()
                    calendar.time = event.date
                    onDateSelected(
                        day = calendar.get(Calendar.DAY_OF_MONTH),
                        month = calendar.get(Calendar.MONTH),
                        year = calendar.get(Calendar.YEAR)
                    )
                    onTimeSelected(
                        hour = calendar.get(Calendar.HOUR_OF_DAY),
                        minute = calendar.get(Calendar.MINUTE)
                    )
                    obtainState {
                        copy(
                            eventId = event.id,
                            isNewEvent = false,
                            name = name.copy(value = event.name),
                            description = description.copy(value = event.description ?: ""),
                            city = city.copy(value = event.city ?: ""),
                            currentWeatherDegreeInCelsius = event.weatherDegreeInCelsius,
                            currentWeatherImageUrl = event.weatherImageUrl,
                            address = address.copy(value = event.address ?: "")
                        )
                    }
                }
            }
        }
    }

    data class State(
        val eventId: Long? = null,
        val isNewEvent: Boolean = true,
        val name: UITextField = UITextField(
            required = true,
            titleResId = R.string.name,
            placeHolderResId = R.string.enter_name,
            maxLeathers = 100
        ),
        val description: UITextField = UITextField(
            required = false,
            titleResId = R.string.description,
            placeHolderResId = R.string.enter_description,
            maxLeathers = 1000
        ),
        val date: UITextField = UITextField(
            required = true,
            titleResId = R.string.date,
            placeHolderResId = R.string.enter_date,
            maxLeathers = 100
        ),
        val time: UITextField = UITextField(
            required = true,
            titleResId = R.string.time,
            placeHolderResId = R.string.enter_time,
            maxLeathers = 100
        ),
        val city: UITextField = UITextField(
            required = true,
            titleResId = R.string.city,
            placeHolderResId = R.string.enter_city,
            maxLeathers = 100
        ),
        val address: UITextField = UITextField(
            required = false,
            titleResId = R.string.address,
            placeHolderResId = R.string.enter_address,
            maxLeathers = 100
        ),
        val selectedDate: Calendar = GregorianCalendar.getInstance(),
        val weatherList: List<Weather> = emptyList(),
        val currentWeatherImageUrl: String? = null,
        val currentWeatherDegreeInCelsius: String? = null,
        val showDatePicker: Boolean = false
    )

    sealed class Action {
        object OnBackPressed : Action()
        object OnContinueClick : Action()
        class OnNameChange(val value: String) : Action()
        class OnDescriptionChange(val value: String) : Action()
        class OnCityValueChange(val value: String) : Action()
        class OnAddressValueChange(val value: String) : Action()
        class OnDatePickerStateChange(val show: Boolean) : Action()
        class OnTimeSelect(val hour: Int, val minute: Int) : Action()
        class OnDateSelect(val day: Int, val month: Int, val year: Int) : Action()
    }

    sealed class Effect {
        object OnBackPressed : Effect()
    }

    override fun handleAction(action: Action) {
        when (action) {
            is Action.OnBackPressed -> {
                obtainEffect {
                    Effect.OnBackPressed
                }
            }
            is Action.OnContinueClick -> {
                onContinueClick()
            }
            is Action.OnCityValueChange -> {
                obtainState {
                    copy(
                        city = city.copy(
                            value = action.value,
                            isError = false
                        )
                    )
                }
                validateDataAndShowWeather()
            }
            is Action.OnAddressValueChange -> {
                obtainState {
                    copy(
                        address = address.copy(
                            value = action.value,
                            isError = false
                        )
                    )
                }
            }
            is Action.OnNameChange -> {
                obtainState {
                    copy(
                        name = name.copy(
                            value = action.value,
                            isError = false
                        )
                    )
                }
            }
            is Action.OnDescriptionChange -> {
                obtainState {
                    copy(
                        description = description.copy(
                            value = action.value,
                            isError = false
                        )
                    )
                }
            }
            is Action.OnDatePickerStateChange -> {
                obtainState {
                    copy(
                        showDatePicker = action.show
                    )
                }
            }
            is Action.OnTimeSelect -> {
                onTimeSelected(hour = action.hour, minute = action.minute)
            }
            is Action.OnDateSelect -> {
                onDateSelected(day = action.day, month = action.month, year = action.year)
            }
        }.exhaustive
    }


    private fun onTimeSelected(hour: Int, minute: Int) {
        val localTime = LocalTime.of(hour, minute)
        uiState.value.selectedDate.apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val text: String = localTime.format(formatter)
        obtainState {
            copy(
                selectedDate = uiState.value.selectedDate,
                time = time.copy(
                    value = text,
                    isError = false,
                )
            )
        }
        getCurrentWeather()
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        uiState.value.selectedDate.set(year, month, day)
        val pattern = "MM/dd/yyyy"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val text = simpleDateFormat.format(uiState.value.selectedDate.time)
        obtainState {
            copy(
                selectedDate = uiState.value.selectedDate,
                date = date.copy(
                    value = text,
                    isError = false,
                )
            )
        }
        getCurrentWeather()
    }

    private fun validateDataAndShowWeather() {
        checkWeatherJob?.cancel()
        checkWeatherJob = CoroutineScope(Dispatchers.IO).launch {
            getWeatherUseCase(uiState.value.city.value).collectLatest { weatherList ->
                obtainState {
                    copy(
                        weatherList = weatherList
                    )
                }
                getCurrentWeather()
            }
        }
    }

    private fun onContinueClick() {
        viewModelScope.launch(Dispatchers.IO) {
            val state = uiState.value
            var isDateInvalid = false
            if (state.name.isDataRequiredButNotDefined()) {
                isDateInvalid = true
                obtainState {
                    copy(
                        name = state.name.copy(
                            isError = true
                        )
                    )
                }
            }
            if (state.date.isDataRequiredButNotDefined()) {
                isDateInvalid = true
                obtainState {
                    copy(
                        date = state.date.copy(
                            isError = true
                        )
                    )
                }
            }
            if (state.time.isDataRequiredButNotDefined()) {
                isDateInvalid = true
                obtainState {
                    copy(
                        time = state.time.copy(
                            isError = true
                        )
                    )
                }
            }
            if (state.city.isDataRequiredButNotDefined()) {
                isDateInvalid = true
                obtainState {
                    copy(
                        city = state.city.copy(
                            isError = true
                        )
                    )
                }
            }
            if (isDateInvalid) {
                return@launch
            }

            addEventUseCase(
                id = state.eventId,
                name = state.name.value,
                description = state.description.value.getNullIfEmpty(),
                city = state.city.value.getNullIfEmpty(),
                selectedDate = state.selectedDate.time,
                weatherImageUrl = state.currentWeatherImageUrl,
                degreeInCelsius = state.currentWeatherDegreeInCelsius,
                address = state.address.value.getNullIfEmpty(),
            )
            obtainEffect {
                Effect.OnBackPressed
            }
        }
    }

    private fun getCurrentWeather() {
        obtainState {
            val currentWeather =
                weatherList.minByOrNull { Math.abs(selectedDate.time.time - it.date) }
            currentWeather
            copy(
                currentWeatherDegreeInCelsius = currentWeather?.degreeInCelsius,
                currentWeatherImageUrl = currentWeather?.imageUrl
            )
        }
    }
}