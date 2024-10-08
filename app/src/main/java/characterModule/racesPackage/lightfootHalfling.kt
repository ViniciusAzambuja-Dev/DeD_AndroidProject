package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class lightfootHalfling() : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementCharisma(1)
    }
}