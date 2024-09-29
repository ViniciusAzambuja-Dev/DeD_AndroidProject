package com.example.ded

import PersonagemViewModel.PersonagemViewModel
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    private val personagemViewModel: PersonagemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "criar_personagem") {
                    composable("criar_personagem") {
                        CriarPersonagemScreen(navController, personagemViewModel)
                    }
                    composable("atribuir_pontos") {
                        AtribuirPontosScreen(personagemViewModel)
                    }
                }
        }
    }
}

