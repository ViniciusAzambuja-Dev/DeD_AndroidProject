package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class Drow() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaCarisma(1)
    }
}