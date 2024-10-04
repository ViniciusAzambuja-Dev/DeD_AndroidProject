package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class ElfoDaFloresta() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaSabedoria(1)
    }
}