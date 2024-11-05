package com.example.ded

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.ded.characterModule.characterPackage.Character
import com.example.ded.characterModule.characterPackage.characterCreator
import com.example.ded.data.AttributesDAO
import com.example.ded.data.CharacterDAO
import com.example.ded.data.CharacterDB
import com.example.ded.entity.AttributesEntity
import com.example.ded.entity.CharacterEntity
import kotlinx.coroutines.launch
import viewModel.AttributesViewModel
import viewModel.CharacterViewModel

class createCharacterActivity : AppCompatActivity() {
    private lateinit var characterViewModel : CharacterViewModel
    private lateinit var attributesViewModel: AttributesViewModel

    private lateinit var characterDAO: CharacterDAO
    private lateinit var attributesDAO: AttributesDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = CharacterDB.getDatabase(this)
        characterDAO = db.characterDAO()
        attributesDAO = db.attributesDAO()

        characterViewModel = CharacterViewModel(characterDAO)
        attributesViewModel = AttributesViewModel(attributesDAO)

        setContent {
            createCharacterScreen(::saveCharacter)
        }
    }

    fun saveCharacter(character: Character, raceOption : Int){
        lifecycleScope.launch {
            val attributesEntity = AttributesEntity()
            val attributeId = attributesViewModel.saveAttributes(attributesEntity)

            val characterEntity = CharacterEntity()
            characterEntity.name = character.getName()
            characterEntity.attributesId = attributeId.toInt()
            characterEntity.raceId = raceOption

            characterViewModel.saveCharacter(characterEntity)
        }
    }
}

@Composable
fun createCharacterScreen(saveCharacter: (Character, raceOption : Int) -> Unit) {
    var name by remember { mutableStateOf("") }
    var raceNumber by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val context = LocalContext.current

    val racaList = listOf(
        1 to "Alto Elfo",
        2 to "Draconato",
        3 to "Gnomo",
        4 to "Halfling Pés Leves",
        5 to "Meio-Orc",
        6 to "Anão",
        7 to "Drow",
        8 to "Gnomo da Floresta",
        9 to "Halfling Robusto",
        10 to "Tiefling",
        11 to "Anão da Colina",
        12 to "Elfo",
        13 to "Gnomo das Rochas",
        14 to "Humano",
        15 to "Anão da Montanha",
        16 to "Elfo da Floresta",
        17 to "Halfling",
        18 to "Meio-Elfo"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
    ) {

        Text(
            text = "Criação de Personagem",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Nome do personagem") },
            modifier = Modifier.fillMaxWidth(),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Selecione a raça:",
                modifier = Modifier.weight(1f),
                fontSize = 18.sp
            )

            TextField(
                value = raceNumber,
                onValueChange = { newValue ->
                    if (newValue.all { char -> char.isDigit() } && newValue.length <= 2) {
                        raceNumber = newValue
                    }
                },
                placeholder = { Text(text = "Número da raça") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            racaList.chunked(6).forEach { chunk ->
                Column(modifier = Modifier.weight(1f)) {
                    chunk.forEach { (number, race) ->
                        Text(
                            text = "$number - $race",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }

        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        try {
                            val raceOption = raceNumber
                            val character = characterCreator.createCharacter(name, raceOption)

                            saveCharacter(character, raceOption.toInt())

                            val intent = Intent(context, assignPointsActivity::class.java)
                            intent.putExtra("personagem", character)
                            context.startActivity(intent)
                        } catch (e: IllegalArgumentException) {
                            message = e.message ?: "Erro ao criar personagem"
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                ) {
                    Text(text = "Criar Personagem")
                }
            }
        }
    }
}