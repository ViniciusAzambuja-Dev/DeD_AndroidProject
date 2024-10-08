package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class rockGnome() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementConstitution(1)
    }
}