package com.example.soccerleauge2.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.soccerleauge2.model.Team


@Dao
interface TeamDAO {

    @Insert
    suspend fun insertAll(vararg team: Team) : List<Long>

    @Query("SELECT*FROM team")
    suspend fun getAllTeam() : List<Team>

    @Query("DELETE FROM team")
    suspend fun deleteAllTeam()

}

