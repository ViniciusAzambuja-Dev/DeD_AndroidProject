package org.example.Racas

import org.example.Personagem.Personagem

class Elfo() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaDestreza(2)
    }
}