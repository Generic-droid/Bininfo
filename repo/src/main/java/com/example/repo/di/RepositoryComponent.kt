package com.example.repo.di

import com.example.core.di.RepoProvider
import com.example.database.di.DatabaseComponent
import com.example.network.di.NetworkComponent
import dagger.Component

@Component(
    dependencies = [DatabaseComponent::class, NetworkComponent::class],
    modules = [RepositoryModule::class, DispatchersModule::class]
)
interface RepositoryComponent : RepoProvider {

    @Component.Factory
    interface Factory {
        fun create(
            databaseComponent: DatabaseComponent,
            networkComponent: NetworkComponent
        ): RepositoryComponent
    }
}