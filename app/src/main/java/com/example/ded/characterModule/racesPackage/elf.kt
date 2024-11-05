package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class elf(override val raceName: String = "elf") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(2)
    }
}