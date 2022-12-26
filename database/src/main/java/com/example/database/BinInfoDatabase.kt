package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.daos.BinInfoDao
import com.example.database.entities.BinInfoEntity

const val DATABASE_VERSION = 1

@Database(entities = [BinInfoEntity::class], exportSchema = false, version = DATABASE_VERSION)
abstract class BinInfoDatabase : RoomDatabase() {

    abstract fun binInfoDao(): BinInfoDao

    companion object {

        @Volatile
        private var INSTANCE: BinInfoDatabase? = null

        fun getDataBase(context: Context): BinInfoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BinInfoDatabase::class.java,
                    "bin_info_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}