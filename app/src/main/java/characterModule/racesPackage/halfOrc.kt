package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class halfOrc() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementStrength(2)
        attributes.incrementConstitution(1)
    }

}