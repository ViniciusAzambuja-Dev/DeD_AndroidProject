package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class forestGnome() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementDexterity(1)
    }
}