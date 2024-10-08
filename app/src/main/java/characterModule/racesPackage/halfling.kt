package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class halfling() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(2)
    }
}