package com.example.network

import com.example.network.models.BinInfoDto
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

private const val BASE_URL =
    "https://lookup.binlist.net"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NetworkClient {
    @GET("{id}")
    suspend fun getBinInfo(@Path("id") query: String): BinInfoDto
}

class NetworkClientImpl @Inject constructor() {
    companion object {
        val retrofitService: NetworkClient by lazy {
            retrofit.create(NetworkClient::class.java)
        }
    }
}