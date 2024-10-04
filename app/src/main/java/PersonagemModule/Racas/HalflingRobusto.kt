package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class HalflingRobusto() : Raca {
    override fun implementaBonus(atributos : Atributos) {
       atributos.incrementaConstituicao(1)
    }
}