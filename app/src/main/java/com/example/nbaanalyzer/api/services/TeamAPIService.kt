package com.example.nbaanalyzer.api.services

import com.example.nbaanalyzer.api.responses.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamAPIService {
    @GET("advancedStatisticsCalculator/team-stats/{team_id}")
    fun getTeamStats(@Path("team_id") team_id: Int): Call<TeamResponse>
}