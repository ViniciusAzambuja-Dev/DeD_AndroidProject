package com.example.ded.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "character",
    foreignKeys = [
        ForeignKey(
            entity = AttributesEntity::class,
            parentColumns = arrayOf("attributesId"),
            childColumns = arrayOf("attributesId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = RaceEntity::class,
            parentColumns = arrayOf("raceId"),
            childColumns = arrayOf("raceId"),
            onDelete = ForeignKey.CASCADE
        )
    ],indices = [
        Index(value = ["attributesId"]),
        Index(value = ["raceId"])
    ]
)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var attributesId: Int = 0,
    var raceId: Int = 0,
    var name: String = "",
)

