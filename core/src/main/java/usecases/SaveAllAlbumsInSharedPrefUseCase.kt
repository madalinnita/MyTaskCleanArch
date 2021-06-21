package usecases

import model.Album
import repositories.SharedPrefRepository

class SaveAllAlbumsInSharedPrefUseCase(private val sharedPrefRepository: SharedPrefRepository) {
    fun execute(albums: List<Album>) {
        sharedPrefRepository.saveAllAlbums(albums)
    }
}