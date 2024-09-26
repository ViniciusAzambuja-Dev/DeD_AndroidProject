package org.example.Racas

import org.example.Personagem.Personagem

class Tiefling() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaInteligencia(1)
        personagem.atributos.incrementaCarisma(2)
    }
}