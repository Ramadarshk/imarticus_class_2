package com.example.imarticus_class_2

//import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.Serializable
//import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private  val url="https://android-kotlin-fun-mars-server.appspot.com"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit= Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
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

//@Serializable
data class MarsPhoto(
    val id: String="",
    //@Json(name = "img_src")
    @Json(name = "img_src")
    val img_src: String=""
)