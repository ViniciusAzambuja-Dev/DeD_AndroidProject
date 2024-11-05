package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class halfElf(override val raceName: String = "halfElf") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementCharisma(2)
    }
}