package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class drow() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementCharisma(1)
    }
}