package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class forestElf() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementWisdom(1)
    }
}