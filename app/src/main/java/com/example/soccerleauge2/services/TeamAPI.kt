package com.example.soccerleauge2.services

import com.example.soccerleauge2.model.Team
import io.reactivex.Single
import retrofit2.http.GET

interface TeamAPI {

    @GET("tugceerdogan/JSONDataSet/master/teams.json")
    fun getTeam() : Single<List<Team>>



}