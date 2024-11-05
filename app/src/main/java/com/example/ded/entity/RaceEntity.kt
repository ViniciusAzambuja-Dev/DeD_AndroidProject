package com.example.ded.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "races")
data class RaceEntity(
    @PrimaryKey(autoGenerate = true)
    var raceId : Int = 0,
    var nameRace : String = ""
)
