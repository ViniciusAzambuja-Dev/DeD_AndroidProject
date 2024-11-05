package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class drow(override val raceName: String = "drow") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementCharisma(1)
    }
}