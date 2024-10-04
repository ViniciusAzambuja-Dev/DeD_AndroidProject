package com.example.ded

import PersonagemViewModel.PersonagemViewModel
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

@Composable
fun MenuFinalScreen(personagemViewModel: PersonagemViewModel){

    val personagem = personagemViewModel.personagem

    Column(modifier = Modifier.padding(16.dp).fillMaxHeight()) {
        Text(
            text = "Personagem: ${personagem?.getNome()}",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        ShowAtributo("Força", getHabilidades = { personagem?.atributos?.getForca() })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAtributo("Destreza", getHabilidades = { personagem?.atributos?.getDestreza() })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAtributo("Constituição", getHabilidades = { personagem?.atributos?.getConstituicao() })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAtributo("Inteligência", getHabilidades = { personagem?.atributos?.getInteligencia() })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAtributo("Sabedoria", getHabilidades = { personagem?.atributos?.getSabedoria() })
        Spacer(modifier = Modifier.height(12.dp))
        ShowAtributo("Carisma", getHabilidades = { personagem?.atributos?.getCarisma()})
        Spacer(modifier = Modifier.height(40.dp))
        ShowAtributo("Pontos de vida", getHabilidades = { personagem?.getPontosVida()})
    }
}

@Composable
fun ShowAtributo(nomeHabilidade: String, getHabilidades: () -> Int?){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = nomeHabilidade,
            fontSize = 28.sp,
            color = Color.Blue,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${getHabilidades()}",
            fontSize = 28.sp,
            color = Color.Red,
            modifier = Modifier.weight(1f).wrapContentWidth(Alignment.End)
        )
    }
}