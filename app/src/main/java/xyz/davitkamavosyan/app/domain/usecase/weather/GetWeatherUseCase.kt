package xyz.davitkamavosyan.app.domain.usecase.weather

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import xyz.davitkamavosyan.app.datasource.remote.model.project.RemoteWeatherItem
import xyz.davitkamavosyan.app.domain.model.Weather
import xyz.davitkamavosyan.app.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val mapper: (RemoteWeatherItem) -> Weather
) {
    suspend operator fun invoke(city: String): Flow<List<Weather>> {
        return weatherRepository.getGeo(city = city).map {
            if (it.isNotEmpty()) {
                weatherRepository.getWeather(
                    lat = it[0].lat,
                    lon = it[0].lon
                ).catch {emptyList<Weather>() }.first().list.map(mapper)
            } else {
                emptyList()
            }
        }.catch {
            emptyList<Weather>()
        }
    }
}