package com.example.mytaskcleanarch.data.di

import com.example.mytaskcleanarch.presentation.albumlist.AlbumListViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single { AlbumListViewModel(get(), get(), get(), get()) }

}