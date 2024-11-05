package com.example.ded

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.ded.characterModule.characterPackage.Character
import com.example.ded.data.AttributesDAO
import com.example.ded.data.CharacterDAO
import com.example.ded.data.CharacterDB
import com.example.ded.data.RacesDAO
import kotlinx.coroutines.launch
import viewModel.AttributesViewModel
import viewModel.CharacterViewModel
import viewModel.RaceViewModel

class finalMenuActivity : AppCompatActivity() {
    private lateinit var characterViewModel : CharacterViewModel
    private lateinit var attributesViewModel: AttributesViewModel
    private lateinit var raceViewModel: RaceViewModel

    private lateinit var characterDAO: CharacterDAO
    private lateinit var attributesDAO: AttributesDAO
    private lateinit var raceDao : RacesDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = CharacterDB.getDatabase(this)
        characterDAO = db.characterDAO()
        attributesDAO = db.attributesDAO()
        raceDao = db.racesDAO()

        characterViewModel = CharacterViewModel(characterDAO)
        attributesViewModel = AttributesViewModel(attributesDAO)
        raceViewModel = RaceViewModel(raceDao)
        val character: Character? = intent.getSerializableExtra("personagem") as? Character

        setContent {
            if (character != null) {
                finalMenuScreen(character, ::deleteCharacter)
            }
        }

        printCharacterAttributes()
    }

    fun deleteCharacter(){
        lifecycleScope.launch {
            val characterList = characterViewModel.getCharacterList()
            val character = characterList.last()

            raceViewModel.deleteRace(character.raceId)
            attributesViewModel.deleteAttribute(character.attributesId)
            characterViewModel.deleteCharacter(character)
        }
    }

    private fun printCharacterAttributes() {
        lifecycleScope.launch {
            val characterList = characterViewModel.getCharacterList()
            val attributesList = attributesViewModel.getAttributesList()

            for (character in characterList) {
                val attributes = attributesList.find { it.attributesId == character.attributesId }
                if (attributes != null) {
                    println("Id do Personagem: ${character.id}")
                    println("Id da Raca: ${character.raceId}")
                    println("Nome do Personagem: ${character.name}")
                    println("Forca: ${attributes.selectSkill(1)}")
                    println("Destreza: ${attributes.selectSkill(2)}")
                    println("Constituicao: ${attributes.selectSkill(3)}")
                    println("Inteligencia: ${attributes.selectSkill(4)}")
                    println("Sabedoria: ${attributes.selectSkill(5)}")
                    println("Carisma: ${attributes.selectSkill(6)}")
                    println("Pontos Restantes: ${attributes.selectSkill(7)}")
                    println("Pontos de Vida: ${attributes.selectSkill(8)}\n\n")
                } else {
                    println("Atributos nao encontrados para o personagem: ${character.name}")
                }
            }
        }
    }
}

@Composable
fun finalMenuScreen(character: Character, deleteCharacter:() -> Unit){

    Column(modifier = Modifier.padding(16.dp).fillMaxHeight()) {
        Text(
            text = "Personagem: ${character.getName()}",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        ShowAttribute("Força:", getAttribute = { character.attributes.getSkill(1) })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Destreza:", getAttribute = { character.attributes.getSkill(2) })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Constituição:", getAttribute = { character.attributes.getSkill(3) })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Inteligência:", getAttribute = { character.attributes.getSkill(4) })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Sabedoria:", getAttribute = { character.attributes.getSkill(5) })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Carisma:", getAttribute = { character.attributes.getSkill(6)})
        Spacer(modifier = Modifier.height(40.dp))
        ShowAttribute("Pontos de vida:", getAttribute = { character.attributes.getSkill(8)})
        Spacer(modifier = Modifier.height(12.dp))
        ShowAttribute("Pontos Restantes:", getAttribute = { character.attributes.getSkill(7)})

        Button(onClick = deleteCharacter, modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Text("Deletar Personagem")
        }
    }
}

@Composable
fun ShowAttribute(nameLabel: String, getAttribute: () -> Int?){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = nameLabel,
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${getAttribute()}",
            fontSize = 28.sp,
            color = Color.Red,
            modifier = Modifier.weight(1f).wrapContentWidth(Alignment.End)
        )
    }
}