package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class halfOrc(override val raceName: String = "halfOrc") : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementStrength(2)
        attributes.incrementConstitution(1)
    }

}