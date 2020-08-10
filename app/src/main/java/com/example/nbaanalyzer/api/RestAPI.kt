package com.example.nbaanalyzer.api

import com.example.nbaanalyzer.api.responses.PointsDistributionData
import com.example.nbaanalyzer.api.responses.TeamResponse
import com.example.nbaanalyzer.api.services.TeamAPIService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestAPI(){

    private val  teamAPIService: TeamAPIService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(MoshiConverterFactory.create()).build()

        teamAPIService = retrofit.create(TeamAPIService::class.java)
    }

    fun getTeamStats(team_id: Int): Call<TeamResponse>{
        return teamAPIService.getTeamStats(team_id)
    }

    fun getTeamPointsDistribution(team_id: Int): Call<PointsDistributionData>{
        return teamAPIService.getTeamPointsDistribution(team_id)
    }

}
