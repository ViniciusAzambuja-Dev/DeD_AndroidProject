package com.example.ded.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ded.entity.RaceEntity

@Dao
interface RacesDAO {
    @Insert
    suspend fun insertAllRaces(races: List<RaceEntity>)

    @Query("DELETE FROM races WHERE raceId = :raceId")
    suspend fun deleteRaceById(raceId : Int)

    @Query("SELECT * FROM races")
    suspend fun selectAllRaces() : List<RaceEntity>
}