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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import characterModule.characterPackage.Character

class finalMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val character: Character? = intent.getSerializableExtra("personagem") as? Character
        character?.addRaceBonus(character.attributes)
        character?.healthPointsModifier()
        setContent {
            if (character != null) {
                finalMenuScreen(character)
            }
        }
    }
}

@Composable
fun finalMenuScreen(character: Character){

    Column(modifier = Modifier.padding(16.dp).fillMaxHeight()) {
        Text(
            text = "Personagem: ${character.getName()}",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        showAttribute("Força:", getAttribute = { character.attributes.getSkill(1) })
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Destreza:", getAttribute = { character.attributes.getSkill(2) })
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Constituição:", getAttribute = { character.attributes.getSkill(3) })
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Inteligência:", getAttribute = { character.attributes.getSkill(4) })
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Sabedoria:", getAttribute = { character.attributes.getSkill(5) })
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Carisma:", getAttribute = { character.attributes.getSkill(6)})
        Spacer(modifier = Modifier.height(40.dp))
        showAttribute("Pontos de vida:", getAttribute = { character.getHealthPoints()})
        Spacer(modifier = Modifier.height(12.dp))
        showAttribute("Pontos Restantes:", getAttribute = { character.attributes.getSkill(7)})
    }
}

@Composable
fun showAttribute(nameLabel: String, getAttribute: () -> Int?){
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