package com.example.buku.network

import com.example.buku.data.BukuIT
import com.example.buku.data.BukuJapan
import com.example.buku.network.Poetry
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://gutendex.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PoetryServiceApi{
    @GET("books/?topic=japan")
    suspend fun getData() : List<BukuJapan>
}

object PoetryApi{
    val retrofitServiceApi : PoetryServiceApi by lazy {
    retrofit.create(PoetryServiceApi::class.java)
    }
}