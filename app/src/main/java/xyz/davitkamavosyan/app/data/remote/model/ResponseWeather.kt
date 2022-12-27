package xyz.davitkamavosyan.app.datasource.remote.model.project

import com.google.gson.annotations.SerializedName

data class ResponseWeather(

	@field:SerializedName("city")
	val city: City,

	@field:SerializedName("cnt")
	val cnt: Int,

	@field:SerializedName("cod")
	val cod: String,

	@field:SerializedName("message")
	val message: Int,

	@field:SerializedName("list")
	val list: List<RemoteWeatherItem>
)

data class City(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("coord")
	val coord: Coord,

	@field:SerializedName("sunrise")
	val sunrise: Int,

	@field:SerializedName("timezone")
	val timezone: Int,

	@field:SerializedName("sunset")
	val sunset: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("population")
	val population: Int
)

data class Rain(

	@field:SerializedName("3h")
	val jsonMember3h: Double
)

data class Wind(

	@field:SerializedName("deg")
	val deg: Int,

	@field:SerializedName("speed")
	val speed: Double,

	@field:SerializedName("gust")
	val gust: Double
)

data class Clouds(

	@field:SerializedName("all")
	val all: Int
)

data class WeatherItem(

	@field:SerializedName("icon")
	val icon: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("main")
	val main: String,

	@field:SerializedName("id")
	val c: Int
)

data class Coord(

	@field:SerializedName("lon")
	val lon: Double,

	@field:SerializedName("lat")
	val lat: Double
)

data class Sys(

	@field:SerializedName("pod")
	val pod: String
)

data class Main(

	@field:SerializedName("temp")
	val temp: Double,

	@field:SerializedName("temp_min")
	val tempMin: Double,

	@field:SerializedName("grnd_level")
	val grndLevel: Int,

	@field:SerializedName("temp_kf")
	val tempKf: Double,

	@field:SerializedName("humidity")
	val humidity: Int,

	@field:SerializedName("pressure")
	val pressure: Int,

	@field:SerializedName("sea_level")
	val seaLevel: Int,

	@field:SerializedName("feels_like")
	val feelsLike: Double,

	@field:SerializedName("temp_max")
	val tempMax: Double
)

data class RemoteWeatherItem(

	@field:SerializedName("dt")
	val dt: Long,

	@field:SerializedName("pop")
	val pop: Int,

	@field:SerializedName("visibility")
	val visibility: Int,

	@field:SerializedName("dt_txt")
	val dtTxt: String,

	@field:SerializedName("weather")
	val weather: List<WeatherItem>,

	@field:SerializedName("main")
	val main: Main,

	@field:SerializedName("clouds")
	val clouds: Clouds,

	@field:SerializedName("sys")
	val sys: Sys,

	@field:SerializedName("wind")
	val wind: Wind,

	@field:SerializedName("rain")
	val rain: Rain
)
