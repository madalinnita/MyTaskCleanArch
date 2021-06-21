package com.example.mytaskcleanarch.data.api

import model.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>
}