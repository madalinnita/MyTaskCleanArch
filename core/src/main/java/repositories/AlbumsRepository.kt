package repositories

import model.Album
import util.AppResult

interface AlbumsRepository {
    suspend fun getAlbums(): AppResult<List<Album>>
}