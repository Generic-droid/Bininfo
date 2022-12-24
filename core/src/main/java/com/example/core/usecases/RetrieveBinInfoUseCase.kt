package com.example.core.usecases

import com.example.core.repos.NetworkRepo

class RetrieveBinInfoUseCase(
    private val networkRepo: NetworkRepo
) {
    suspend operator fun invoke(bin: String) {
        networkRepo.retrieveBinInfo()
    }
}