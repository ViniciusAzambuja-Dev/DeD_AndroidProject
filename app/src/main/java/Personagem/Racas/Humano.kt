package org.example.Racas

import org.example.Personagem.Personagem

class Humano() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.atributos.incrementaForca(1)
        personagem.atributos.incrementaDestreza(1)
        personagem.atributos.incrementaConstituicao(1)
        personagem.atributos.incrementaInteligencia(1)
        personagem.atributos.incrementaSabedoria(1)
        personagem.atributos.incrementaCarisma(1)
    }
}