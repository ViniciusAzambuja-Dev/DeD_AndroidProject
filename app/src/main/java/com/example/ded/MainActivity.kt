package com.example.ded

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ded.data.CharacterDB
import com.example.ded.data.RacesDAO
import com.example.ded.entity.RaceEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var racesDAO: RacesDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = CharacterDB.getDatabase(this)
        racesDAO = db.racesDAO()

        lifecycleScope.launch {
            initializeRaces()

            delay(2000)

            val intent = Intent(this@MainActivity, createCharacterActivity::class.java)
            startActivity(intent)
        }
    }

    private suspend fun initializeRaces() {
        if (racesDAO.selectAllRaces().isEmpty()) {
            val defaultRaces = listOf(
                RaceEntity(nameRace = "alto elfo"),
                RaceEntity(nameRace = "draconato"),
                RaceEntity(nameRace = "gnomo"),
                RaceEntity(nameRace = "halfling pes leves"),
                RaceEntity(nameRace = "meio orc"),
                RaceEntity(nameRace = "anão"),
                RaceEntity(nameRace = "drow"),
                RaceEntity(nameRace = "gnomo da floresta"),
                RaceEntity(nameRace = "halfling robusto"),
                RaceEntity(nameRace = "tiefling"),
                RaceEntity(nameRace = "anão da colina"),
                RaceEntity(nameRace = "elfo"),
                RaceEntity(nameRace = "gnomo das rochas"),
                RaceEntity(nameRace = "humano"),
                RaceEntity(nameRace = "anão da montanha"),
                RaceEntity(nameRace = "elfo da floresta"),
                RaceEntity(nameRace = "halfling"),
                RaceEntity(nameRace = "meio elfo")
            )

            racesDAO.insertAllRaces(defaultRaces)

        }
    }
}