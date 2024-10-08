package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class mountainDwarf() : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementStrength(2)
    }
}