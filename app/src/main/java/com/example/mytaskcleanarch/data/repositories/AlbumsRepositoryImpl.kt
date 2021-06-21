package com.example.mytaskcleanarch.data.repositories

import com.example.mytaskcleanarch.data.api.AlbumsApi
import model.Album
import repositories.AlbumsRepository
import util.AppResult

class AlbumsRepositoryImpl(private val albumsApi: AlbumsApi) : AlbumsRepository {
    override suspend fun getAlbums(): AppResult<List<Album>> {
        val response = albumsApi.getAlbums()

        return if (response.isSuccessful) {
            AppResult.Success(response.body() ?: arrayListOf())
        } else {
            AppResult.Error(Exception(response.message()))
        }
    }
}