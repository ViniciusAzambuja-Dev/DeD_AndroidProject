package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class forestGnome(override val raceName: String = "forestGnome") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(1)
    }
}