package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class mountainDwarf(override val raceName: String = "mountainDwarf") : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementStrength(2)
    }
}