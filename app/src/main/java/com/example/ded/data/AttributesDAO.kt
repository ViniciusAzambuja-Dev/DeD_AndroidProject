package com.example.ded.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ded.entity.AttributesEntity


@Dao
interface AttributesDAO {
    @Insert
    suspend fun insert(attributesEntity: AttributesEntity) : Long

    @Query("SELECT * FROM attributes")
    suspend fun selectAllAttributes() : List<AttributesEntity>

    @Query("DELETE FROM attributes WHERE attributesId = :attributeId")
    suspend fun deleteAttributeById(attributeId: Int)

    @Query
    ("""UPDATE attributes 
        SET strength = :strength, dexterity = :dexterity, constitution = :constitution, 
        intelligence = :intelligence, wisdom = :wisdom, charisma = :charisma, 
        skillPoints = :skillPoints, healthPoints = :healthPoints 
        WHERE attributesId = :idAttribute""")
        suspend fun updateAttributes(
            idAttribute: Int,
            strength: Int,
            dexterity: Int,
            constitution: Int,
            intelligence: Int,
            wisdom: Int,
            charisma: Int,
            skillPoints: Int,
            healthPoints: Int
        )

}