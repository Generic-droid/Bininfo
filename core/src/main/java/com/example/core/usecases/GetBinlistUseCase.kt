package com.example.core.usecases

import com.example.core.repos.Repository
import javax.inject.Inject

class GetBinlistUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.getBinInfoList()
}