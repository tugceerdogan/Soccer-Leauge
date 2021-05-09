package com.example.soccerleauge2.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.soccerleauge2.model.Team


@Database(entities = arrayOf(Team::class),version = 1)

abstract class TeamDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDAO

    //Singleton

    companion object {

        @Volatile private var  instance : TeamDatabase? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock){

            instance ?: databaseOlustur(context).also{
                instance = it
            }

        }


        private fun databaseOlustur(context : Context) = Room.databaseBuilder(
                context.applicationContext,
                TeamDatabase::class.java
                ,"teamdatabase").build()


    }




}