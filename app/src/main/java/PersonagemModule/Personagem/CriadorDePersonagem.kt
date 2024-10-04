package org.example.Personagem

import org.example.Racas.*


class CriadorDePersonagem {

    companion object{

        fun criarPlayer(nome : String, opcaoDeRaca : String) : Personagem{
            if (nome.isEmpty()){
                throw IllegalArgumentException("Nome Vazio");
            }
            else if (opcaoDeRaca.isEmpty()) {
                throw IllegalArgumentException("Campo de raça vazio");
            }
            else {
               val opcaoRaca = opcaoDeRaca.toInt()
               return when (opcaoRaca) {
                    1 -> Personagem(AltoElfo(), nome)
                    2 -> Personagem(Draconato(), nome)
                    3 -> Personagem(Gnomo(), nome)
                    4 -> Personagem(HalflingPesLeves(), nome)
                    5 -> Personagem(MeioOrc(), nome)
                    6 -> Personagem(Anao(), nome)
                    7 -> Personagem(Drow(), nome)
                    8 -> Personagem(GnomoDaFloresta(), nome)
                    9 -> Personagem(HalflingRobusto(), nome)
                    10 -> Personagem(Tiefling(), nome)
                    11 -> Personagem(AnaoDaColina(), nome)
                    12 -> Personagem(Elfo(), nome)
                    13 -> Personagem(GnomoDasRochas(), nome)
                    14 -> Personagem(Humano(), nome)
                    15 -> Personagem(AnaoDaMontanha(), nome)
                    16 -> Personagem(ElfoDaFloresta(), nome)
                    17 -> Personagem(Halfling(), nome)
                    18 -> Personagem(MeioElfo(), nome)
                   else -> {throw IllegalArgumentException("Opção de raça invalida")}
               }
            }
        }
    }
}