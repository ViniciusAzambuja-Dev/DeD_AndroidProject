package com.example.ded.characterModule.characterPackage

import com.example.ded.characterModule.racesPackage.Race
import java.io.Serializable

class Character : Serializable{
    private var name : String
    private var race : Race
    private var raceName : String
    internal var attributes : Attributes

    constructor(race : Race, name : String){
        this.race = race
        this.name = name
        this.attributes = Attributes()
        this.raceName = race.raceName
    }

    fun getName(): String {
        return name
    }
    internal fun addRaceBonus(attributes: Attributes){
        race.applyBonus(attributes)
    }
}


