package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class AnaoDaColina() : Raca {
    override fun implementaBonus(atributos : Atributos) {
       atributos.incrementaSabedoria(1)
    }
}