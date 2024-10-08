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
import kotlinx.coroutines.delay
import characterModule.characterPackage.Character

class assignPointsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val character: Character? = intent.getSerializableExtra("personagem") as? Character
        setContent {
            if (character != null) {
                assignPointsScreen(character)
            }
        }
    }
}

@Composable
fun assignPointsScreen(character: Character) {

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
            attributeInputRow("Força", character, skillOption = 1, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            attributeInputRow("Destreza", character, skillOption = 2, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            attributeInputRow("Constituição", character, skillOption = 3, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            attributeInputRow("Inteligência", character, skillOption = 4, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            attributeInputRow("Sabedoria", character, skillOption = 5, updatePoints = { remainingPoints = character.attributes.getSkill(7) })
            Spacer(modifier = Modifier.height(8.dp))
            attributeInputRow("Carisma", character, skillOption = 6, updatePoints = { remainingPoints = character.attributes.getSkill(7) })

            Text(
                text = remainingPoints.toString(),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        Button(
            onClick = {
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
fun attributeInputRow(skillName: String, character: Character, skillOption: Int, updatePoints: () -> Unit) {
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