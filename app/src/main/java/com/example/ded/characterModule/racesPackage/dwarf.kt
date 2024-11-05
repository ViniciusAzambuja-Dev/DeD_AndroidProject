package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class dwarf(override val raceName: String = "dwarf") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementConstitution(2)
    }

}