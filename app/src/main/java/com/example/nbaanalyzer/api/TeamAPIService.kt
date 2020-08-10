package com.example.nbaanalyzer.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamAPIService {
    @GET("advancedStatisticsCalculator/team-players-stats/{teamID}")
    fun getTeamStats(@Path("teamID") team_id: Int): Call<TeamResponse>

    @GET( "dbmanager/get-team-distributed-points/{team_id}")
    fun getTeamPointsDistribution(@Path("team_id") team_id: Int): Call<PointsDistributionData>

    @GET("http://127.0.0.1:8000/dbmanager/get-defend-info/{player_id}/{player_position}")
    fun getPlayerDefendInfo(@Path("player_id") player_id: Int,
                            @Path("player_position") player_position: String): Call<DefendDataResponse>

}