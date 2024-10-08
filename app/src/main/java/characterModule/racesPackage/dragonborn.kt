package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class dragonborn() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementStrength(2)
        attributes.incrementCharisma(1)
    }
}