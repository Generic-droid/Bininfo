package com.example.core

import com.example.core.di.ApplicationProvider

interface App {
    fun getAppComponent(): ApplicationProvider
}