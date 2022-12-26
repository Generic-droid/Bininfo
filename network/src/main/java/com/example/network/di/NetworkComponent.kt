package com.example.network.di

import com.example.network.NetworkClient
import dagger.Component

interface NetworkProvider {
    fun provideNetworkApiService() : NetworkClient
}

@Component(modules = [NetworkModule::class])
interface NetworkComponent : NetworkProvider {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}