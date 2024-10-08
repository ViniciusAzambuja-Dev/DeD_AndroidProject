package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class gnome() : Race {
    override fun applyBonus(attributes : Attributes) {
        attributes.incrementIntelligence(2)
    }
}