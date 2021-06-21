package com.example.mytaskcleanarch.presentation

import android.app.Application
import com.example.mytaskcleanarch.BuildConfig
import com.example.mytaskcleanarch.data.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinExperimentalAPI
import org.koin.core.context.startKoin

class MyTaskCleanArchApplication : Application() {

    @KoinExperimentalAPI
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyTaskCleanArchApplication)
            if (BuildConfig.DEBUG) {
                androidLogger()
            }
            modules(
                arrayListOf(
                    apiModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    authUseCases
                )
            )
        }
    }
}