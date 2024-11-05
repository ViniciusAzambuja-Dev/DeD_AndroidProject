package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class forestElf(override val raceName: String = "forestElf") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementWisdom(1)
    }
}