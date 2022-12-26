package com.example.core.di

import com.example.core.repos.Repository

interface ApplicationProvider : RepoProvider

interface RepoProvider {

    fun provideRepository(): Repository
}