package com.example.binlist

import android.app.Application
import com.example.binlist.di.AppComponent
import com.example.binlist.di.DaggerAppComponent
import com.example.core.App
import com.example.core.di.ApplicationProvider
import com.example.database.di.DaggerDatabaseComponent
import com.example.network.di.DaggerNetworkComponent
import com.example.repo.di.DaggerRepositoryComponent

class BinlistApplication : Application(), App {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initDi()
    }

    private fun initDi() {
        val databaseComponent = DaggerDatabaseComponent.factory()
            .create(this@BinlistApplication)
        val networkComponent = DaggerNetworkComponent.factory()
            .create()
        val repositoryComponent = DaggerRepositoryComponent.factory()
            .create(databaseComponent, networkComponent)

        appComponent = DaggerAppComponent.factory()
            .create(repositoryComponent)
    }

    override fun getAppComponent(): ApplicationProvider = appComponent
}