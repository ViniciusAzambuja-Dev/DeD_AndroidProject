package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class halfling(override val raceName: String = "halfling") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(2)
    }
}