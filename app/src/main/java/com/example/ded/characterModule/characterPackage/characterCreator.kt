package com.example.ded.characterModule.characterPackage

import com.example.ded.characterModule.racesPackage.*

class characterCreator {

    companion object{

        fun createCharacter(name : String, skillOption : String) : Character {
            if (name.isEmpty()){
                throw IllegalArgumentException("Nome Vazio");
            }
            else if (skillOption.isEmpty()) {
                throw IllegalArgumentException("Campo de raça vazio");
            }
            else {
               val option = skillOption.toInt()
               return when (option) {
                    1 -> Character(highElf(), name)
                    2 -> Character(dragonborn(), name)
                    3 -> Character(gnome(), name)
                    4 -> Character(lightfootHalfling(), name)
                    5 -> Character(halfOrc(), name)
                    6 -> Character(dwarf(), name)
                    7 -> Character(drow(), name)
                    8 -> Character(forestGnome(), name)
                    9 -> Character(robustHalfling(), name)
                    10 -> Character(tiefling(), name)
                    11 -> Character(hillDwarf(), name)
                    12 -> Character(elf(), name)
                    13 -> Character(rockGnome(), name)
                    14 -> Character(human(), name)
                    15 -> Character(mountainDwarf(), name)
                    16 -> Character(forestElf(), name)
                    17 -> Character(halfling(), name)
                    18 -> Character(halfElf(), name)
                   else -> {throw IllegalArgumentException("Opção de raça invalida")}
               }
            }
        }
    }
}