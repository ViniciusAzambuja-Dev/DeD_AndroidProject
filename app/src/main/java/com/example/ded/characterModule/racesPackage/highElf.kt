package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class highElf(override val raceName: String = "highElf") : Race {
    override fun applyBonus(attributes: Attributes) {
        attributes.incrementIntelligence(1)
    }
}