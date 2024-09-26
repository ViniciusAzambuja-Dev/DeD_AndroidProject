package org.example.Racas

import org.example.Personagem.Personagem

class HalflingPesLeves() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaCarisma(1)
    }
}