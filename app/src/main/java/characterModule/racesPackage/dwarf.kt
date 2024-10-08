package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class dwarf() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementConstitution(2)
    }

}