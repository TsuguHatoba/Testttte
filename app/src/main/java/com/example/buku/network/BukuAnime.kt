package com.example.buku.network

import com.squareup.moshi.Json


data class BukuAnime (

  @Json(name = "items"      ) val items      : List<Items> = listOf()

)