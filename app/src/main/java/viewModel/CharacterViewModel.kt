package viewModel

import androidx.lifecycle.ViewModel
import com.example.ded.data.CharacterDAO
import com.example.ded.entity.CharacterEntity

class CharacterViewModel(private val characterDAO: CharacterDAO) : ViewModel() {

    suspend fun saveCharacter(characterEntity: CharacterEntity){
        characterDAO.insert(characterEntity)
    }

    suspend fun deleteCharacter(characterEntity: CharacterEntity){
        characterDAO.delete(characterEntity)
    }

    suspend fun getCharacterList() : List<CharacterEntity>{
        return characterDAO.selectAllCharacter()
    }

}