package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes

class lightfootHalfling(override val raceName: String = "lightfootHalfling") : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementCharisma(1)
    }
}