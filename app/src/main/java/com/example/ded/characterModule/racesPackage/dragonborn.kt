package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class dragonborn(override val raceName: String = "dragonborn") : Race {

    override fun applyBonus(attributes : Attributes) {
        attributes.incrementStrength(2)
        attributes.incrementCharisma(1)
    }
}