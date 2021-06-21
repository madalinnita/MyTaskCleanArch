package repositories

import model.Album

interface SharedPrefRepository {
    fun saveAllAlbums(albums: List<Album>)
    fun getAllAlbums(): List<Album?>?
}