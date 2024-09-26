package org.example.Racas

import org.example.Personagem.Personagem

class Draconato() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaForca(2)
        personagem.atributos.incrementaCarisma(1)
    }
}