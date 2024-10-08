package characterModule.characterPackage

import characterModule.racesPackage.Race
import java.io.Serializable

class Character : Serializable{
    private var race : Race
    private var healthPoints : Int
    private var name : String
    internal var attributes : Attributes

    constructor(race : Race, name : String){
        this.race = race
        this.healthPoints = 10
        this.name = name
        this.attributes = Attributes()
    }

   fun getName(): String {
        return name
   }
   fun getHealthPoints(): Int {
        return healthPoints
   }

   internal fun healthPointsModifier(){

        when(attributes.getSkill(3)){
                1 -> healthPoints -= 5
                2, 3 -> healthPoints -=4
                4, 5 -> healthPoints -= 3
                6, 7 -> healthPoints -= 2
                8, 9 -> healthPoints -= 1
                12, 13 -> healthPoints += 1
                14, 15 -> healthPoints += 2
                16, 17 -> healthPoints += 3
                18, 19 -> healthPoints += 4
                20, 21 -> healthPoints += 5
                22, 23 -> healthPoints += 6
                24, 25 -> healthPoints += 7
                26, 27 -> healthPoints += 8
                28, 29 -> healthPoints += 9
                30 -> healthPoints += 10
        }
    }

    internal fun addRaceBonus(attributes: Attributes){
        race.applyBonus(attributes)
    }
}
