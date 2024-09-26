package org.example.Racas

import org.example.Personagem.Personagem

class AnaoDaMontanha() :  Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaForca(2)
    }
}