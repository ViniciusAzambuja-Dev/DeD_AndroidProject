package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class gnome(override val raceName: String = "gnome") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementIntelligence(2)
    }
}