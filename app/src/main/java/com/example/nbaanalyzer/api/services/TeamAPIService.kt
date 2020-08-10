package com.example.nbaanalyzer.api.services

import com.example.nbaanalyzer.api.responses.PointsDistributionData
import com.example.nbaanalyzer.api.responses.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamAPIService {
    @GET("advancedStatisticsCalculator/team-players-stats/{teamID}")
    fun getTeamStats(@Path("teamID") team_id: Int): Call<TeamResponse>

    @GET( "dbmanager/get-team-distributed-points/{team_id}")
    fun getTeamPointsDistribution(@Path("team_id") team_id: Int): Call<PointsDistributionData>

}