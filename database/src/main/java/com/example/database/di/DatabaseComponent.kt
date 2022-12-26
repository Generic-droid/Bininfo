package com.example.database.di

import android.content.Context
import com.example.database.daos.BinInfoDao
import dagger.BindsInstance
import dagger.Component

interface DaoProvider {
    fun provideBinInfoDao(): BinInfoDao
}

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent : DaoProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DatabaseComponent
    }
}