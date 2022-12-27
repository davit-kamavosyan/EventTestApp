package xyz.davitkamavosyan.app.domain.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import xyz.davitkamavosyan.app.data.remote.ApiService
import xyz.davitkamavosyan.app.datasource.remote.model.project.ResponseGeoItem
import xyz.davitkamavosyan.app.datasource.remote.model.project.ResponseWeather
import xyz.davitkamavosyan.app.datasource.remote.safeApiCall

class WeatherRepository(
    private val service: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getGeo(city: String): Flow<List<ResponseGeoItem>> {
        return safeApiCall(dispatcher) {
            service.getGeo(countryCity = city)
        }
    }

    suspend fun getWeather(
        lat: Double,
        lon: Double,
    ): Flow<ResponseWeather> {
        return safeApiCall(dispatcher) {
            service.getWeather(
                lat = lat,
                lon = lon
            )
        }
    }
}