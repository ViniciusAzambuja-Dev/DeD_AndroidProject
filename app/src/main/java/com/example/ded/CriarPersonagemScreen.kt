package com.example.ded

import androidx.compose.runtime.Composable
import PersonagemViewModel.PersonagemViewModel
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.example.Personagem.CriadorDePersonagem
import org.example.Personagem.Personagem

@Composable
fun CriarPersonagemScreen(
    navController: NavHostController,
    personagemViewModel: PersonagemViewModel
) {
    var nome by remember { mutableStateOf("") }
    var numeroRaca by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }
    var personagem by remember { mutableStateOf<Personagem?>(null) }

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Criação de Personagem",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TextField(
                value = nome,
                onValueChange = { nome = it },
                placeholder = { Text(text = "Nome do personagem") },
                modifier = Modifier.fillMaxWidth()
            )
        }

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
                value = numeroRaca,
                onValueChange = { newValue ->
                    if (newValue.all { char -> char.isDigit() } && newValue.length <= 2) {
                        numeroRaca = newValue
                    }
                },
                placeholder = { Text(text = "Número da raça") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            racaList.chunked(6).forEach { chunk ->
                Column(modifier = Modifier.weight(1f)) {
                    chunk.forEach { (numero, raca) ->
                        Text(
                            text = "$numero - $raca",
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
                    text = mensagem,
                    fontSize = 16.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        try {
                            val opcaoDeRaca = numeroRaca
                            personagem = CriadorDePersonagem.criarPlayer(nome, opcaoDeRaca)
                            personagemViewModel.personagem = personagem
                            mensagem = "Personagem criado! Nome: ${personagem?.getNome()}"
                            navController.navigate("atribuir_pontos")
                        } catch (e: IllegalArgumentException) {
                            mensagem = e.message ?: "Erro ao criar personagem"
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