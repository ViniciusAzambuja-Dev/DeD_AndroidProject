package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class Draconato() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaForca(2)
        atributos.incrementaCarisma(1)
    }
}