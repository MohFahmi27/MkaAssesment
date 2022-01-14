package com.mohfahmi.mkaassesment

import android.app.Application
import com.mohfahmi.mkaassesment.di.useCaseModule
import com.mohfahmi.mkaassesment.di.viewModelModule
import com.mohfahmi.mkaassesment.domain.di.networkModule
import com.mohfahmi.mkaassesment.domain.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(networkModule, repositoryModule, useCaseModule, viewModelModule)
            )
        }
    }
}