package com.example.ded.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "attributes")
data class AttributesEntity(
    @PrimaryKey(autoGenerate = true)
    var attributesId: Int = 0,
    var strength : Int = 8,
    var dexterity : Int = 8,
    var constitution : Int = 8,
    var intelligence : Int = 8,
    var wisdom : Int = 8,
    var charisma : Int = 8,
    var skillPoints: Int = 27,
    var healthPoints: Int = 10,
){
    @Ignore
    fun selectSkill(number: Int): Int {
        return when (number) {
            1 -> strength
            2 -> dexterity
            3 -> constitution
            4 -> intelligence
            5 -> wisdom
            6 -> charisma
            7 -> skillPoints
            8 -> healthPoints
            else -> throw IllegalArgumentException("Erro inesperado!")
        }
    }
}

