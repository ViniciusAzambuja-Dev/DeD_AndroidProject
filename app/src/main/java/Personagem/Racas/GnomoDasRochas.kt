package org.example.Racas

import org.example.Personagem.Personagem

class GnomoDasRochas() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaConstituicao(1)
    }
}