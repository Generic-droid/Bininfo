package com.example.core.usecases

import com.example.core.repos.Repository
import javax.inject.Inject

class RetrieveBinInfoUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(query: String) =
        repository.fetchBinInfo(query = query)
}