package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class elf() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(2)
    }
}