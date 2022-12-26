package com.example.network.di

import com.example.network.NetworkClientImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providesNetworkClient() = NetworkClientImpl.retrofitService
}