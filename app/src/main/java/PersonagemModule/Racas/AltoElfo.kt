package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class AltoElfo() : Raca {
    override fun implementaBonus(atributos: Atributos) {
        atributos.incrementaInteligencia(1)
    }
}