package org.example.Racas

import org.example.Personagem.Personagem

class HalflingRobusto() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaConstituicao(1)
    }
}