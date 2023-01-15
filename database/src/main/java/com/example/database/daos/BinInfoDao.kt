package com.example.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entities.BinInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BinInfoDao {

    @Query("SELECT * FROM bin_info_table")
    fun getBinInfoList(): Flow<List<BinInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(binInfoEntity: BinInfoEntity)

}