package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class Tiefling() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaInteligencia(1)
        atributos.incrementaCarisma(2)
    }
}