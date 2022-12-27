package xyz.davitkamavosyan.app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import xyz.davitkamavosyan.app.datasource.remote.model.project.ResponseGeoItem
import xyz.davitkamavosyan.app.datasource.remote.model.project.ResponseWeather

interface ApiService {

    @GET("/geo/1.0/direct")
    suspend fun getGeo(
        @Query("q") countryCity: String,
        @Query("appid") appId: String = "9e9756915198187260f700f98619f656",
        @Query("limit") limit: Int = 1,
    ): List<ResponseGeoItem>

    @GET("/data/2.5/forecast")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String = "9e9756915198187260f700f98619f656",
    ): ResponseWeather
}

