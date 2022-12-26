package com.example.database.di

import android.content.Context
import com.example.database.BinInfoDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabase(context: Context) = BinInfoDatabase.getDataBase(context)

    @Provides
    fun providesBinInfoDao(database: BinInfoDatabase) = database.binInfoDao()
}