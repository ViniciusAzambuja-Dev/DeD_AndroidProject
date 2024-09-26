package org.example.Racas

import org.example.Personagem.Personagem

class MeioOrc() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaForca(2)
        personagem.atributos.incrementaConstituicao(1)
    }

}