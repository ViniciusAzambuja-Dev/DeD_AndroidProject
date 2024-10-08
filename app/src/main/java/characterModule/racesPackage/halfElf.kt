package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class halfElf() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementCharisma(2)
    }
}