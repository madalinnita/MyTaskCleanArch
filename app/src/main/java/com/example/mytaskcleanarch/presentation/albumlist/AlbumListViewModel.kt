package com.example.mytaskcleanarch.presentation.albumlist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytaskcleanarch.utils.ConnectivityUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Album
import usecases.GetAlbumsUserCase
import usecases.GetAllAlbumsFromSharedPrefUseCase
import usecases.SaveAllAlbumsInSharedPrefUseCase
import util.AppResult

class AlbumListViewModel(
    private val getAlbumsUserCase: GetAlbumsUserCase,
    private val saveAllAlbumsInSharedPrefUseCase: SaveAllAlbumsInSharedPrefUseCase,
    private val getAllAlbumsFromSharedPrefUseCase: GetAllAlbumsFromSharedPrefUseCase,
    private val context: Context
) : ViewModel() {

    private val _listOfAlbums = MutableLiveData<List<Album>>()
    val listOfAlbums: LiveData<List<Album>> = _listOfAlbums

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAlbums() {
        if (ConnectivityUtils.isConnectionAvailable(context)) {
            viewModelScope.launch {
                _isLoading.value = true

                val result = withContext(Dispatchers.IO) {
                    getAlbumsUserCase.execute()
                }

                if (result is AppResult.Success) {
                    val albums = result.successData!!.sortedBy { it.title }
                    _listOfAlbums.value = albums
                    saveAllAlbumsInSharedPrefUseCase.execute(albums)
                } else if (result is AppResult.Error) {
                    _error.value = result.message ?: result.exception.message
                }
                _isLoading.value = false
            }
        } else {
            val albumsFromCache = getAllAlbumsFromSharedPrefUseCase.execute()
            if (albumsFromCache != null && albumsFromCache.isNotEmpty()) {
                _listOfAlbums.value = albumsFromCache.filterNotNull()
            }
        }
    }
}