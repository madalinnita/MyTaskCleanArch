package com.example.mytaskcleanarch.data.di

import com.example.mytaskcleanarch.data.api.AlbumsApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
   fun provideAlbumsApi(retrofit: Retrofit): AlbumsApi {
      return retrofit.create(AlbumsApi::class.java)
   }
   single { provideAlbumsApi(get()) }
}