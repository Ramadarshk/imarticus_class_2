package com.example.imarticus_class_2

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private  val url="https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit= Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(url)
    .build()
interface sendme{
    @GET("photos")
    suspend fun getphotos():List<MarsPhoto>
}
    object marsapi{
        val retrofits:sendme by lazy{
            retrofit.create(sendme::class.java)
        }
    }

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val img_src: String
)