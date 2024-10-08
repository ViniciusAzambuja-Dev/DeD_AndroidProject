package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class highElf() : Race {
    override fun applyBonus(attributes: Attributes) {
        attributes.incrementIntelligence(1)
    }
}