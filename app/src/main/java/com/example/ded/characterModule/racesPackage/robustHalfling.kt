package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class robustHalfling(override val raceName: String = "robustHalfling") : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementConstitution(1)
    }
}