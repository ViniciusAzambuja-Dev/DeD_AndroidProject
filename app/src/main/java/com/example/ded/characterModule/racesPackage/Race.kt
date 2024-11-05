package com.example.ded.characterModule.racesPackage

import com.example.ded.characterModule.characterPackage.Attributes
import java.io.Serializable

interface Race : Serializable {
    val raceName : String

    fun applyBonus(attributes: Attributes){}
}

