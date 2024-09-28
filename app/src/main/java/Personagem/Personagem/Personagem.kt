package org.example.Personagem

import Personagem.Personagem.Atributos
import org.example.Racas.AltoElfo
import org.example.Racas.Anao
import org.example.Racas.AnaoDaColina
import org.example.Racas.AnaoDaMontanha
import org.example.Racas.Draconato
import org.example.Racas.Drow
import org.example.Racas.Elfo
import org.example.Racas.ElfoDaFloresta
import org.example.Racas.Gnomo
import org.example.Racas.GnomoDaFloresta
import org.example.Racas.GnomoDasRochas
import org.example.Racas.Halfling
import org.example.Racas.HalflingPesLeves
import org.example.Racas.HalflingRobusto
import org.example.Racas.Humano
import org.example.Racas.MeioElfo
import org.example.Racas.MeioOrc
import org.example.Racas.Raca

class Personagem {
    private var raca : Raca
    private var pontosDeVida : Int
    private var nome : String
    var atributos : Atributos

    constructor(raca : Raca, nome : String){
        this.raca = raca
        this.pontosDeVida = 10
        this.nome = nome
        this.atributos = Atributos()
    }

    fun getNome(): String {
        return nome
    }

   /* fun modificadorPontosDeVida(){

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

    fun adicionarBonusRaca(personagem: Personagem){
        raca.implementaBonus(personagem)
    }

    override fun toString() : String{
        return "\nNome do jogador " + nome + "\n" +
                "Nivel: " + nivel + "\n" +
                "Pontos de Vida: " + pontosDeVida + "\n" +
                "Pontos de habilidade: " + pontosDeHabilidade + "\n" +
                "Força: " + forca + "\n" +
                "Destreza: " + destreza + "\n" +
                "Constituicao: " + constituicao + "\n" +
                "Inteligencia: " + inteligencia + "\n" +
                "Sabedoria: " + sabedoria + "\n" +
                "Carisma: " + carisma + "\n"
    }
   */
}