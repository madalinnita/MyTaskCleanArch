package com.example.mytaskcleanarch.data.di

import android.content.Context
import com.example.mytaskcleanarch.data.api.AlbumsApi
import com.example.mytaskcleanarch.data.repositories.AlbumsRepositoryImpl
import com.example.mytaskcleanarch.data.repositories.SharedPrefRepositoryImpl
import org.koin.dsl.module
import repositories.AlbumsRepository
import repositories.SharedPrefRepository

val repositoryModule = module {
    fun provideAlbumRepository(albumsApi: AlbumsApi): AlbumsRepository {
        return AlbumsRepositoryImpl(albumsApi)
    }
    single { provideAlbumRepository(get()) }

    fun provideSharedPrefRepository(context: Context): SharedPrefRepository {
        return SharedPrefRepositoryImpl(context)
    }
    single { provideSharedPrefRepository(get()) }

}