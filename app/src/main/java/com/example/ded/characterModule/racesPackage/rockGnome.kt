package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class rockGnome(override val raceName: String = "rockGnome") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementConstitution(1)
    }
}