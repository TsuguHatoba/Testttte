package com.example.buku.network

import com.squareup.moshi.Json

data class Books(
    @Json(name = "title") val title        : String? = null,
    @Json(name = "subtitle" ) var subtitle : String? = null,
    @Json(name = "isbn13"   ) var isbn13   : String? = null,
    @Json(name = "price"    ) var price    : String? = null,
    @Json(name = "image"    ) var image    : String? = null
)