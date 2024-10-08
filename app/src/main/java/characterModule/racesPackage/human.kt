package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class human() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementStrength(1)
        attributes.incrementDexterity(1)
        attributes.incrementConstitution(1)
        attributes.incrementIntelligence(1)
        attributes.incrementWisdom(1)
        attributes.incrementCharisma(1)
    }
}