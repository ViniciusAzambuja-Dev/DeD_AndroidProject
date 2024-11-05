package viewModel

import androidx.lifecycle.ViewModel
import com.example.ded.characterModule.characterPackage.Attributes
import com.example.ded.data.AttributesDAO
import com.example.ded.entity.AttributesEntity

class AttributesViewModel(private val attributesDAO: AttributesDAO) :ViewModel() {

    suspend fun saveAttributes(attributesEntity: AttributesEntity) : Long{
       val id = attributesDAO.insert(attributesEntity)
        return id
    }

    suspend fun deleteAttribute(attributeId : Int){
        attributesDAO.deleteAttributeById(attributeId)
    }

    suspend fun getAttributesList() : List<AttributesEntity>{
        return attributesDAO.selectAllAttributes()
    }

    suspend fun updateAttributes(attributesEntity: AttributesEntity){
        attributesDAO.updateAttributes(
            attributesEntity.attributesId, attributesEntity.selectSkill(1),
            attributesEntity.selectSkill(2), attributesEntity.selectSkill(3),
            attributesEntity.selectSkill(4), attributesEntity.selectSkill(5),
            attributesEntity.selectSkill(6), attributesEntity.selectSkill(7),
            attributesEntity.selectSkill(8)
        )
    }
}