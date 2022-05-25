package com.example.buku.network

import com.squareup.moshi.Json


data class Items (

  @Json(name = "id"         ) var id         : String?     = null,
  @Json(name = "volumeInfo" ) var volumeInfo : VolumeInfo? = VolumeInfo()

)