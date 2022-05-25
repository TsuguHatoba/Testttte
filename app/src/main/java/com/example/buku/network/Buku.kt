package com.example.buku

import com.example.buku.network.Books
import com.squareup.moshi.Json


data class Buku (
  @Json(name = "books"    ) var books    : List<Books> = listOf()
)