package com.example.buku.data

import com.squareup.moshi.Json

data class BukuJapan(

	@Json(name="results")
	val results: ResultsItem? = null
)

data class ResultsItem(

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null,

)
