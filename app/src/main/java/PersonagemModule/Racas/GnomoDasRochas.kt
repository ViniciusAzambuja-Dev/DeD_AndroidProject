package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class GnomoDasRochas() : Raca{
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaConstituicao(1)
    }
}