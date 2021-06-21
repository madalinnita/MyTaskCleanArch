package usecases

import model.Album
import repositories.AlbumsRepository
import util.AppResult

class GetAlbumsUserCase(private val albumsRepository: AlbumsRepository) {
    suspend fun execute(): AppResult<List<Album>> {
        return albumsRepository.getAlbums()
    }
}