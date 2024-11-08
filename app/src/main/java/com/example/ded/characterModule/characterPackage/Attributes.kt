package com.example.ded.characterModule.characterPackage

import java.io.Serializable

class Attributes(
    private var strength : Int = 8,
    private var dexterity : Int = 8,
    private var constitution : Int = 8,
    private var intelligence : Int = 8,
    private var wisdom : Int = 8,
    private var charisma : Int = 8,
    private var healthPoints : Int = 10,
    private var skillPoints: Int = 27) : Serializable{

    fun getSkill(number: Int): Int {
        return when (number) {
            1 -> strength
            2 -> dexterity
            3 -> constitution
            4 -> intelligence
            5 -> wisdom
            6 -> charisma
            7 -> skillPoints
            8-> healthPoints
            else -> throw IllegalArgumentException("Erro inesperado!")
        }
    }

    internal fun incrementStrength(points: Int) {
        strength += points
    }
    internal fun incrementDexterity(points: Int) {
        dexterity += points
    }
    internal fun incrementConstitution(points: Int) {
        constitution += points
    }
    internal fun incrementIntelligence(points: Int) {
        intelligence += points
    }
    internal fun incrementWisdom(points: Int) {
        wisdom += points
    }
    internal fun incrementCharisma(points: Int) {
        charisma += points
    }


    internal fun distributePoints(skillOption : Int, points: Int) {
        if (points > 7 || points < 1) {
            throw IllegalArgumentException("ERRO: Pontos devem ser entre 7 e 1")
        } else if (skillPoints < points) {
            throw IllegalArgumentException("ERRO: Não há pontos suficientes!")
        } else {
            costModifier(skillOption, points)
        }
        when (skillOption) {
            1 -> strength += points
            2 -> dexterity += points
            3 -> constitution += points
            4 -> intelligence += points
            5 -> wisdom += points
            6 -> charisma += points
        }
    }

    private fun costModifier(skillOption: Int, points: Int) {

        val skills = intArrayOf(strength, dexterity, constitution, intelligence, wisdom, charisma)
        val currentSkillValue = skills[skillOption - 1]
        val newSkillValue = currentSkillValue + points

        if (newSkillValue > 15) {
            throw IllegalArgumentException("ERRO: Limite de pontos atingido!")
        }
        var cost = 0
        for (currentPoint in currentSkillValue until newSkillValue) {
            cost += when {
                currentPoint in 8 until 13 -> 1
                currentPoint in 13 until 15 -> 2
                else -> 0
            }
        }
        if (cost > skillPoints) {
            throw IllegalArgumentException("ERRO: Custo maior que a quantidade de pontos restantes!")
        } else {
            skillPoints -= cost
        }
    }

    internal fun healthPointsModifier(){

        when(constitution){
            1 -> healthPoints -= 5
            2, 3 -> healthPoints -=4
            4, 5 -> healthPoints -= 3
            6, 7 -> healthPoints -= 2
            8, 9 -> healthPoints -= 1
            12, 13 -> healthPoints += 1
            14, 15 -> healthPoints += 2
            16, 17 -> healthPoints += 3
            18, 19 -> healthPoints += 4
            20, 21 -> healthPoints += 5
            22, 23 -> healthPoints += 6
            24, 25 -> healthPoints += 7
            26, 27 -> healthPoints += 8
            28, 29 -> healthPoints += 9
            30 -> healthPoints += 10
        }
    }
}