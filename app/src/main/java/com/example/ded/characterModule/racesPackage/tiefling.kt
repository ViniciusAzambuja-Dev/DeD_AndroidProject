package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class tiefling(override val raceName: String = "tiefling") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementIntelligence(1)
        attributes.incrementCharisma(2)
    }
}