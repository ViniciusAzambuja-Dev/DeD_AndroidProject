package com.example.ded.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.ded.entity.AttributesEntity
import com.example.ded.entity.CharacterEntity
import com.example.ded.entity.RaceEntity

@Database(entities = [CharacterEntity::class, AttributesEntity::class, RaceEntity::class], version = 4, exportSchema = false)
abstract class CharacterDB: RoomDatabase() {

    abstract fun attributesDAO(): AttributesDAO
    abstract fun characterDAO(): CharacterDAO
    abstract fun racesDAO(): RacesDAO

    companion object{

        @Volatile
        private var INSTANCIA: CharacterDB? =null

        fun getDatabase(context: Context): CharacterDB{
            return INSTANCIA ?: synchronized(this){
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDB::class.java,
                    "characterDB"
                ).fallbackToDestructiveMigration().build()
                INSTANCIA = instancia
                return instancia
            }
        }
    }
}