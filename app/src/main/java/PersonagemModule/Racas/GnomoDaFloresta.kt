package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class GnomoDaFloresta() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaDestreza(1)
    }
}