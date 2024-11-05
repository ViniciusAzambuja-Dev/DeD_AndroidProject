package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class hillDwarf(override val raceName: String = "hillDwarf") : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementWisdom(1)
    }
}