package xyz.davitkamavosyan.app.datasource.remote.model.project

import com.google.gson.annotations.SerializedName

data class ResponseGeoItem(

    @field:SerializedName("country")
    val country: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("lon")
    val lon: Double,

    @field:SerializedName("state")
    val state: String,

    @field:SerializedName("lat")
    val lat: Double
)
