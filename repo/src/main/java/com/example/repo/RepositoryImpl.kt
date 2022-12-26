package com.example.repo

import com.example.core.repos.Repository
import com.example.core.models.BinInfo
import com.example.database.daos.BinInfoDao
import com.example.network.NetworkClient
import com.example.repo.di.IoDispatcher
import com.example.repo.mappers.BinInfoMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient,
    private val binInfoDao: BinInfoDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {
    override suspend fun fetchBinInfo(query: String) {
        withContext(ioDispatcher) {
            val binInfo = networkClient.getBinInfo(query = query)
            binInfoDao.insert(BinInfoMapper().mapToEntity(binInfo))
        }
    }

    override fun getBinInfoList(): Flow<List<BinInfo>> {
        TODO("Not yet implemented")
    }
}