package com.example.ded
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import org.example.Personagem.Personagem
import androidx.compose.ui.focus.onFocusChanged


@Composable
fun AtribuirPontosScreen(personagem: Personagem) {
    var pontosDisponiveis by remember { mutableStateOf(personagem.atributos.getQuantDePontosDeHabilidade()) }
    var pontos by remember { mutableStateOf("") } // Armazena o valor como String
    var mensagem by remember { mutableStateOf("") }

    val habilidades = listOf(
        "Força" to 1,
        "Destreza" to 2,
        "Constituição" to 3,
        "Inteligência" to 4,
        "Sabedoria" to 5,
        "Carisma" to 6
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Pontos Disponíveis: $pontosDisponiveis",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        habilidades.forEach { (habilidade, numero) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = habilidade,
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = pontos,
                    onValueChange = { newValue ->
                        // Permitir apenas números
                        if (newValue.all { it.isDigit() }) {
                            pontos = newValue // Atualiza o valor
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .width(50.dp)
                        .onFocusChanged { focusState ->
                            if (!focusState.isFocused) {
                                // Se perder o foco, processa o valor
                                if (pontos.isNotEmpty()) {
                                    try {
                                        val valor = pontos.toInt()
                                        // Aqui você pode verificar se o valor está dentro do limite de pontos disponíveis
                                        if (valor > pontosDisponiveis) {
                                            throw IllegalArgumentException("Pontos insuficientes disponíveis.")
                                        }
                                        personagem.atributos.distribuirPontos(numero, valor)
                                        pontosDisponiveis -= valor // Atualiza os pontos disponíveis após a distribuição
                                        pontos = "" // Limpa o campo após a distribuição
                                    } catch (e: IllegalArgumentException) {
                                        mensagem = e.message ?: "Erro inesperado"
                                    }
                                }
                            }
                        },
                    enabled = true // O campo é sempre editável
                )

                if (mensagem.isNotEmpty()) {
                    Text(
                        text = mensagem,
                        color = Color.Red,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}