package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class HalflingPesLeves() : Raca {
    override fun implementaBonus(atributos : Atributos) {
       atributos.incrementaCarisma(1)
    }
}