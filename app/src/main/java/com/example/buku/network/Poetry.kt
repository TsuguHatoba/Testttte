package com.example.buku.network

data class Poetry(
    val title : String,
    val author : String,
    val lines : List<String>,
    val linecount : Int
)