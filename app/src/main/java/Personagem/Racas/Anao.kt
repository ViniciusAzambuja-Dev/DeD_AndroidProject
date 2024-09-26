package org.example.Racas

import org.example.Personagem.Personagem

class Anao() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaConstituicao(2)
    }

}