package org.example.Racas

import org.example.Personagem.Personagem

class GnomoDaFloresta() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaDestreza(1)
    }
}