package org.example.Racas

import PersonagemModule.Personagem.Atributos
import org.example.Personagem.Personagem

class Humano() : Raca {
    override fun implementaBonus(atributos : Atributos) {
        atributos.incrementaForca(1)
        atributos.incrementaDestreza(1)
        atributos.incrementaConstituicao(1)
        atributos.incrementaInteligencia(1)
        atributos.incrementaSabedoria(1)
        atributos.incrementaCarisma(1)
    }
}