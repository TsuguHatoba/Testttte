package com.example.buku.data

import com.squareup.moshi.Json

data class BukuIT(

	@Json(name="total")
	val total: String? = null,

	@Json(name="books")
	val books: BooksItem? = null,

	@Json(name="page")
	val page: String? = null,

	@Json(name="error")
	val error: String? = null
)

data class BooksItem(

	@Json(name="image")
	val image: String? = null,

	@Json(name="price")
	val price: String? = null,

	@Json(name="subtitle")
	val subtitle: String? = null,

	@Json(name="isbn13")
	val isbn13: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="url")
	val url: String? = null
)
