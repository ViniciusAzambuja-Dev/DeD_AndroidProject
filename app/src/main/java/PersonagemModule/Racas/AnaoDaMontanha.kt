package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class AnaoDaMontanha() :  Raca {
    override fun implementaBonus(atributos : Atributos) {
       atributos.incrementaForca(2)
    }
}