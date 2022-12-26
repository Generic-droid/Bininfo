package com.example.repo.di

import com.example.core.repos.Repository
import com.example.repo.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds fun bindsRepo(impl: RepositoryImpl): Repository
}