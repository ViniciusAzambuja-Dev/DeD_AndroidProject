package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class tiefling() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementIntelligence(1)
        attributes.incrementCharisma(2)
    }
}