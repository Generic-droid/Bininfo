package com.example.binlist.di

import com.example.core.di.ApplicationProvider
import com.example.core.di.RepoProvider
import dagger.Component

@Component(
    dependencies = [RepoProvider::class],
    modules = [AppModule::class]
)
interface AppComponent : ApplicationProvider {

    @Component.Factory
    interface Factory {
        fun create(repoProvider: RepoProvider): AppComponent
    }
}