package characterModule.racesPackage

import characterModule.characterPackage.Attributes

class robustHalfling() : Race {
    override fun applyBonus(attributes : Attributes) {
       attributes.incrementConstitution(1)
    }
}