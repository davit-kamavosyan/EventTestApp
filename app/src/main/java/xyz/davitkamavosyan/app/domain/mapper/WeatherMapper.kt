package xyz.davitkamavosyan.app.domain.mapper

import xyz.davitkamavosyan.app.datasource.remote.model.project.RemoteWeatherItem
import xyz.davitkamavosyan.app.domain.model.Weather
import java.text.DecimalFormat

class WeatherMapper : (RemoteWeatherItem) -> Weather {
    override fun invoke(item: RemoteWeatherItem) = Weather(
        date = item.dt,
        imageUrl = getIconUrl(item.weather.getOrNull(0)?.icon),
        type = item.weather.getOrNull(0)?.main,
        degreeInCelsius = kelvinToCelsius(item.main.temp)
    )
}

private fun getIconUrl(iconId: String?): String? {
    iconId ?: return null
    return "https://openweathermap.org/img/wn/$iconId@2x.png"
}

private fun kelvinToCelsius(degreeInKelvin: Double): String {
    val decimalFormat = DecimalFormat("#.##")
    return decimalFormat.format(degreeInKelvin - 273.15)
}
