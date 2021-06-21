package usecases

import model.Album
import repositories.SharedPrefRepository

class GetAllAlbumsFromSharedPrefUseCase(private val sharedPrefRepository: SharedPrefRepository) {
    fun execute(): List<Album?>? = sharedPrefRepository.getAllAlbums()
}