package com.example.ded
import PersonagemViewModel.PersonagemViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.Personagem.Personagem
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import kotlinx.coroutines.delay

@Composable
fun AtribuirPontosScreen(personagemViewModel: PersonagemViewModel) {
    val personagem = personagemViewModel.personagem
    val focusManager = LocalFocusManager.current
    var pontosRestantes by remember { mutableStateOf(personagem?.atributos?.getQuantDePontosDeHabilidade()) }

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
        if(personagem !=null) {
            AtributoInputRow("Força", personagem, opcaoHabilidade = 1, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })
            Spacer(modifier = Modifier.height(8.dp))
            AtributoInputRow("Destreza", personagem, opcaoHabilidade = 2, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })
            Spacer(modifier = Modifier.height(8.dp))
            AtributoInputRow("Constituição", personagem, opcaoHabilidade = 3, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })
            Spacer(modifier = Modifier.height(8.dp))
            AtributoInputRow("Inteligência", personagem, opcaoHabilidade = 4, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })
            Spacer(modifier = Modifier.height(8.dp))
            AtributoInputRow("Sabedoria", personagem, opcaoHabilidade = 5, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })
            Spacer(modifier = Modifier.height(8.dp))
            AtributoInputRow("Carisma", personagem, opcaoHabilidade = 6, updatePontos = { pontosRestantes = personagem.atributos.getQuantDePontosDeHabilidade() })

            Text(
                text = pontosRestantes.toString(),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}


@Composable
fun AtributoInputRow(nomeHabilidade: String, personagem: Personagem, opcaoHabilidade: Int, updatePontos: () -> Unit) {
    var pontos by remember { mutableStateOf("") }
    var mensagemSucesso by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = nomeHabilidade, modifier = Modifier.weight(1f))

        OutlinedTextField(
            value = pontos,
            onValueChange = { newValue ->
                if (newValue.all { it.isDigit() } && newValue.length <= 2) {
                    pontos = newValue
                }
            },
            modifier = Modifier
                .weight(1f)
                .width(50.dp)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused && pontos.isNotEmpty()) {
                        try {
                            val valorPontos = pontos.toInt()

                            personagem.atributos.distribuirPontos(opcaoHabilidade, valorPontos)
                            updatePontos()
                            pontos = ""
                            mensagemSucesso = "$nomeHabilidade incrementada com sucesso"
                        } catch (e: IllegalArgumentException) {
                            mensagemErro = e.message ?: "Erro inesperado"
                            pontos = ""
                        }
                    }
                }
        )
    }

    if (mensagemSucesso.isNotEmpty()) {
        Text(
            text = mensagemSucesso,
            color = Color.Green,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    } else if (mensagemErro.isNotEmpty()) {
        Text(
            text = mensagemErro,
            color = Color.Red,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
    LaunchedEffect(mensagemSucesso, mensagemErro) {
        if (mensagemSucesso.isNotEmpty() || mensagemErro.isNotEmpty()) {
            delay(3000)
            mensagemSucesso = ""
            mensagemErro = ""
        }
    }
}