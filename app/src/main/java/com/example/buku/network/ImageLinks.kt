package com.example.buku.network

import com.squareup.moshi.Json


data class ImageLinks (

  @Json(name = "thumbnail"      ) val thumbnail      : String? = null

)