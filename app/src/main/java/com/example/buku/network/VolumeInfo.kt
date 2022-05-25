package com.example.buku.network

import com.squareup.moshi.Json


data class VolumeInfo (

  @Json(name = "title"               ) var title               : String?              = null,
  @Json(name = "description"         ) var description         : String?              = null,
  @Json(name = "imageLinks"          ) var imageLinks          : ImageLinks?            = null

)