package org.example.Racas

import org.example.Personagem.Personagem

class AnaoDaColina() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaSabedoria(1)
    }
}