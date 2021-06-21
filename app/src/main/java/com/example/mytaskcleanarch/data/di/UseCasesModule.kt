package com.example.mytaskcleanarch.data.di

import org.koin.dsl.module
import usecases.GetAlbumsUserCase
import usecases.GetAllAlbumsFromSharedPrefUseCase
import usecases.SaveAllAlbumsInSharedPrefUseCase

val authUseCases = module {
    single { GetAlbumsUserCase(get()) }
    single { GetAllAlbumsFromSharedPrefUseCase(get()) }
    single { SaveAllAlbumsInSharedPrefUseCase(get()) }
}