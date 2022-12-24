package com.example.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://lookup.binlist.net"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BinlistApiService {
    @GET("45717360")
    suspend fun getBinInfo(): String
}

object BinlistApi {
    val retrofitService : BinlistApiService by lazy {
        retrofit.create(BinlistApiService::class.java)
    }
}