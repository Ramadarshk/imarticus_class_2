package com.example.imarticus_class_2

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String="",
    //@Json(name = "img_src")
    @Json(name = "img_src")
    val imgsrc: String=""
)
