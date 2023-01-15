package com.example.core.repos

import com.example.core.models.BinInfo
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun fetchBinInfo(query: String): BinInfo

    fun getBinInfoList(): Flow<List<BinInfo>>
}