package com.example.core.repos

interface NetworkRepo {
    suspend fun retrieveBinInfo()
}