package org.example.Racas

import org.example.Personagem.Personagem

class AltoElfo() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaInteligencia(1)
    }
}