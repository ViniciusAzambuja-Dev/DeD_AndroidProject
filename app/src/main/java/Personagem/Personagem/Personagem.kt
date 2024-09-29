package org.example.Personagem

import Personagem.Personagem.Atributos
import org.example.Racas.Raca

class Personagem {
    private var raca : Raca
    private var pontosDeVida : Int
    private var nome : String
    internal var atributos : Atributos

    constructor(raca : Raca, nome : String){
        this.raca = raca
        this.pontosDeVida = 10
        this.nome = nome
        this.atributos = Atributos()
    }

   fun getNome(): String {
        return nome
   }

   internal fun modificadorPontosDeVida(){

        when(atributos.getConstituicao()){
                1 -> pontosDeVida -= 5
                2, 3 -> pontosDeVida -=4
                4, 5 -> pontosDeVida -= 3
                6, 7 -> pontosDeVida -= 2
                8, 9 -> pontosDeVida -= 1
                12, 13 -> pontosDeVida += 1
                14, 15 -> pontosDeVida += 2
                16, 17 -> pontosDeVida += 3
                18, 19 -> pontosDeVida += 4
                20, 21 -> pontosDeVida += 5
                22, 23 -> pontosDeVida += 6
                24, 25 -> pontosDeVida += 7
                26, 27 -> pontosDeVida += 8
                28, 29 -> pontosDeVida += 9
                30 -> pontosDeVida += 10
        }
    }

    internal fun adicionarBonusRaca(personagem: Personagem){
        raca.implementaBonus(personagem)
    }
}