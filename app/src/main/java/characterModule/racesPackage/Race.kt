package characterModule.racesPackage

import characterModule.characterPackage.Attributes
import java.io.Serializable

interface Race : Serializable {
    fun applyBonus(attributes: Attributes){}
}

