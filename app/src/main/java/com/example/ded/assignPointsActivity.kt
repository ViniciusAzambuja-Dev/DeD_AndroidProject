package com.example.ded

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import com.example.ded.characterModule.characterPackage.Character
import com.example.ded.data.AttributesDAO
import com.example.ded.data.CharacterDB
import kotlinx.coroutines.launch
import viewModel.AttributesViewModel

class assignPointsActivity : AppCompatActivity() {

    private lateinit var attributesViewModel: AttributesViewModel
    private lateinit var attributesDAO: AttributesDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = CharacterDB.getDatabase(this)
        attributesDAO = db.attributesDAO()
        attributesViewModel = AttributesViewModel(attributesDAO)

        val character: Character? = intent.getSerializableExtra("personagem") as? Character
        setContent {
            if (character != null) {
                AssignPointsScreen(character, ::saveNewAttributes)
            }
        }
    }

    fun saveNewAttributes(character: Character) {
        lifecycleScope.launch {
            val attributesList = attributesViewModel.getAttributesList()
            val lastAttributesEntity = attributesList.lastOrNull()

            if (lastAttributesEntity != null) {
                lastAttributesEntity.strength = character.attributes.getSkill(1)
                lastAttributesEntity.dexterity = character.attributes.getSkill(2)
                lastAttributesEntity.constitution = character.attributes.getSkill(3)
                lastAttributesEntity.intelligence = character.attributes.getSkill(4)
                lastAttributesEntity.wisdom = character.attributes.getSkill(5)
                lastAttributesEntity.charisma = character.attributes.getSkill(6)
                lastAttributesEntity.skillPoints = character.attributes.getSkill(7)
                lastAttributesEntity.healthPoints = character.attributes.getSkill(8)

                attributesViewModel.updateAttributes(lastAttributesEntity)
            }
        }
    }
}

@Composable
fun AssignPointsScreen(character: Character, saveNewAttributes: (character: Character) -> Unit ) {

    val focusManager = LocalFocusManager.current
    var remainingPoints by remember { mutableIntStateOf(character.attributes.getSkill(7)) }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp).fillMaxHeight().clickable { focusManager.clearFocus() }) {

        Text(
            text = "Atribuir Pontos de Habilidade",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Pontos iniciais(8)\n\n" +
                    "Max(15)",
            color = Color.Blue,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
            AttributeInputRow("Força", character, skillOption = 1, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            AttributeInputRow("Destreza", character, skillOption = 2, updatePoints = { remainingPoints = character.attributes.getSkill(7)})
            Spacer(modifier = Modifier.height(8.dp))
            AttributeInputRow("Constituição", character, skillOption = 3, updatePoints = { remainingPoints = character.attributes.getSkill(7)})
            Spacer(modifier = Modifier.height(8.dp))
            AttributeInputRow("Inteligência", character, skillOption = 4, updatePoints = { remainingPoints = character.attributes.getSkill(7)} )
            Spacer(modifier = Modifier.height(8.dp))
            AttributeInputRow("Sabedoria", character, skillOption = 5, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            AttributeInputRow("Carisma", character, skillOption = 6, updatePoints = { remainingPoints = character.attributes.getSkill(7) })

            Text(
                text = remainingPoints.toString(),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        Button(
            onClick = {
                character.addRaceBonus(character.attributes)
                character.attributes.healthPointsModifier()

                saveNewAttributes(character)
                val intent = Intent(context, finalMenuActivity::class.java)
                intent.putExtra("personagem", character)
                context.startActivity(intent)
            }
        ) {
            Text("Avançar")
        }
    }
}


@Composable
fun AttributeInputRow(skillName: String, character: Character, skillOption: Int, updatePoints: () -> Unit) {
    var points by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = skillName, modifier = Modifier.weight(1f))

        OutlinedTextField(
            value = points,
            onValueChange = { newValue ->
                if (newValue.all { it.isDigit() } && newValue.length <= 2) {
                    points = newValue
                }
            },
            modifier = Modifier
                .weight(1f)
                .width(50.dp)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused && points.isNotEmpty()) {
                        try {
                            val pointsValue = points.toInt()

                            character.attributes.distributePoints(skillOption, pointsValue)
                            updatePoints()

                            points = ""
                            successMessage = "$skillName incrementada com sucesso"
                        } catch (e: IllegalArgumentException) {
                            errorMessage = e.message ?: "Erro inesperado"
                            points = ""
                        }
                    }
                }
        )
    }

    if (successMessage.isNotEmpty()) {
        Text(
            text = successMessage,
            color = Color.Green,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    } else if (errorMessage.isNotEmpty()) {
        Text(
            text = errorMessage,
            color = Color.Red,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
    LaunchedEffect(successMessage, errorMessage) {
        if (successMessage.isNotEmpty() || errorMessage.isNotEmpty()) {
            delay(3000)
            successMessage = ""
            errorMessage = ""
        }
    }
}