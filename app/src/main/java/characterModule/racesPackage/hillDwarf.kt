package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class hillDwarf() : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementWisdom(1)
    }
}