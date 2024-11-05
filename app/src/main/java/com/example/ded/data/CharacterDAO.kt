package com.example.ded.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ded.entity.CharacterEntity

@Dao
interface CharacterDAO {

    @Insert
    suspend fun insert(characterEntity: CharacterEntity)

   @Delete
    suspend fun delete(characterEntity: CharacterEntity)

    @Query("SELECT * FROM character")
    suspend fun selectAllCharacter() : List<CharacterEntity>

}