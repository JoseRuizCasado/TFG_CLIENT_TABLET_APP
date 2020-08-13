package com.example.nbaanalyzer.api

import com.squareup.moshi.Json

data class TeamResponse(
    @field:Json(name = "team") val team: TeamDataResponse
)

data class TeamDataResponse(
    @field:Json(name = "teamID") val team_id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "abbreviation") val abbreviation: String,
    @field:Json(name = "conference") val conference: String,
    @field:Json(name = "division") val division: String,
    @field:Json(name = "city") val city: String,
    @field:Json(name = "head_coach_name") val head_coach_name: String,
    @field:Json(name = "general_manager_name") val general_manager_name: String,
    @field:Json(name = "played_games") val played_games: Int,
    @field:Json(name = "scored_points") val scored_points: Int,
    @field:Json(name = "conceded_points") val conceded_points: Int,
    @field:Json(name = "field_goals_made") val field_goals_made: Int,
    @field:Json(name = "conceded_field_goals_made") val conceded_field_goals_made: Int,
    @field:Json(name = "field_goals_miss") val field_goals_miss: Int,
    @field:Json(name = "conceded_field_goals_miss") val conceded_field_goals_miss: Int,
    @field:Json(name = "field_goals_attempts") val field_goals_attempts: Int,
    @field:Json(name = "conceded_field_goals_attempts") val conceded_field_goals_attempts: Int,
    @field:Json(name = "three_points_field_goals_made") val three_points_field_goals_made: Int,
    @field:Json(name = "conceded_three_points_field_goals_made") val conceded_three_points_field_goals_made: Int,
    @field:Json(name = "three_points_field_goals_miss") val three_points_field_goals_miss: Int,
    @field:Json(name = "conceded_three_points_field_goals_miss") val conceded_three_points_field_goals_miss: Int,
    @field:Json(name = "three_points_field_goals_attempts") val three_points_field_goals_attempts: Int,
    @field:Json(name = "conceded_three_points_field_goals_attempts") val conceded_three_points_field_goals_attempts: Int,
    @field:Json(name = "free_throws_made") val free_throws_made: Int,
    @field:Json(name = "conceded_free_throws_made") val conceded_free_throws_made: Int,
    @field:Json(name = "free_throws_miss") val free_throws_miss: Int,
    @field:Json(name = "conceded_free_throws_miss") val conceded_free_throws_miss: Int,
    @field:Json(name = "free_throws_attempts") val free_throws_attempts: Int,
    @field:Json(name = "conceded_free_throws_attempts") val conceded_free_throws_attempts: Int,
    @field:Json(name = "assists") val assists: Int,
    @field:Json(name = "conceded_assists") val conceded_assists: Int,
    @field:Json(name = "offensive_rebounds") val offensive_rebounds: Int,
    @field:Json(name = "conceded_offensive_rebounds") val conceded_offensive_rebounds: Int,
    @field:Json(name = "defensive_rebounds") val defensive_rebounds: Int,
    @field:Json(name = "conceded_defensive_rebounds") val conceded_defensive_rebounds: Int,
    @field:Json(name = "steals") val steals: Int,
    @field:Json(name = "conceded_steals") val conceded_steals: Int,
    @field:Json(name = "blocks") val blocks: Int,
    @field:Json(name = "conceded_blocks") val conceded_blocks: Int,
    @field:Json(name = "turnovers") val turnovers: Int,
    @field:Json(name = "conceded_turnovers") val conceded_turnovers: Int,
    @field:Json(name = "personal_fouls") val personal_fouls: Int,
    @field:Json(name = "conceded_personal_fouls") val conceded_personal_fouls: Int,
    @field:Json(name = "scored_points_per_game") val scored_points_per_game: Float,
    @field:Json(name = "field_goals_made_per_game") val field_goals_made_per_game: Float,
    @field:Json(name = "field_goals_miss_per_game") val field_goals_miss_per_game: Float,
    @field:Json(name = "field_goals_attempts_per_game") val field_goals_attempts_per_game: Float,
    @field:Json(name = "three_points_field_goals_made_per_game") val three_points_field_goals_made_per_game: Float,
    @field:Json(name = "three_points_field_goals_attempts_per_game") val three_points_field_goals_attempts_per_game: Float,
    @field:Json(name = "free_throws_made_per_game") val free_throws_made_per_game: Float,
    @field:Json(name = "free_throws_miss_per_game") val free_throws_miss_per_game: Float,
    @field:Json(name = "free_throws_attempts_per_game") val free_throws_attempts_per_game: Float,
    @field:Json(name = "assists_per_game") val assists_per_game: Float,
    @field:Json(name = "offensive_rebounds_per_game") val offensive_rebounds_per_game: Float,
    @field:Json(name = "defensive_rebounds_per_game") val defensive_rebounds_per_game: Float,
    @field:Json(name = "steals_per_game") val steals_per_game: Float,
    @field:Json(name = "blocks_per_game") val blocks_per_game: Float,
    @field:Json(name = "turnovers_per_game") val turnovers_per_game: Float,
    @field:Json(name = "personal_fouls_per_game") val personal_fouls_per_game: Float,
    @field:Json(name = "TmOffRtg") val tmOffRtg: Float,
    @field:Json(name = "TmFloor%") val tmFloor: Float,
    @field:Json(name = "DefRtg") val defRtg: Float,
    @field:Json(name = "Pace") val pace: Float,
    @field:Json(name = "TS%") val tS: Float,
    @field:Json(name = "eFG%") val eFG: Float,
    @field:Json(name = "FTARate") val fTARate: Float,
    @field:Json(name = "3FGARate") val threeFGARate: Float,
    @field:Json(name = "TmOR%") val tmOR: Float,
    @field:Json(name = "TmDR%") val tmDR: Float,
    @field:Json(name = "BLK%") val bLK: Float,
    @field:Json(name = "TOV%") val tOV: Float,
    @field:Json(name = "AST%") val aST: Float,
    @field:Json(name = "STL%") val sTL: Float,
    @field:Json(name = "players") val players: List<PlayerDataResponse>
)

data class PlayerDataResponse (
    @field:Json(name = "player_id") val player_id: Int,
    @field:Json(name = "first_name") val first_name: String,
    @field:Json(name = "last_name") val last_name: String,
    @field:Json(name = "jersey") val jersey: Int,
    @field:Json(name = "birth_date") val birth_date: String,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "weight") val weight: Int,
    @field:Json(name = "position") val position: String,
    @field:Json(name = "cluster") val cluster: Int,
    @field:Json(name = "played_games") val played_games: Int,
    @field:Json(name = "played_minutes") val played_minutes: Int,
    @field:Json(name = "scored_points") val scored_points: Int,
    @field:Json(name = "field_goals_made") val field_goals_made: Int,
    @field:Json(name = "field_goals_miss") val field_goals_miss: Int,
    @field:Json(name = "field_goals_attempts") val field_goals_attempts: Int,
    @field:Json(name = "three_points_field_goals_made") val three_points_field_goals_made: Int,
    @field:Json(name = "three_points_field_goals_miss") val three_points_field_goals_miss: Int,
    @field:Json(name = "three_points_field_goals_attempts") val three_points_field_goals_attempts: Int,
    @field:Json(name = "free_throws_made") val free_throws_made: Int,
    @field:Json(name = "free_throws_miss") val free_throws_miss: Int,
    @field:Json(name = "free_throws_attempts") val free_throws_attempts: Int,
    @field:Json(name = "assists") val assists: Int,
    @field:Json(name = "offensive_rebounds") val offensive_rebounds: Int,
    @field:Json(name = "defensive_rebounds") val defensive_rebounds: Int,
    @field:Json(name = "steals") val steals: Int,
    @field:Json(name = "blocks") val blocks: Int,
    @field:Json(name = "turnovers") val turnovers: Int,
    @field:Json(name = "personal_fouls") val personal_fouls: Int,
    @field:Json(name = "played_minutes_per_game") val played_minutes_per_game: Float,
    @field:Json(name = "scored_points_per_game") val scored_points_per_game: Float,
    @field:Json(name = "field_goals_made_per_game") val field_goals_made_per_game: Float,
    @field:Json(name = "field_goals_miss_per_game") val field_goals_miss_per_game: Float,
    @field:Json(name = "field_goals_attempts_per_game") val field_goals_attempts_per_game: Float,
    @field:Json(name = "three_points_field_goals_made_per_game") val three_points_field_goals_made_per_game: Float,
    @field:Json(name = "three_points_field_goals_attempts_per_game") val three_points_field_goals_attempts_per_game: Float,
    @field:Json(name = "free_throws_made_per_game") val free_throws_made_per_game: Float,
    @field:Json(name = "free_throws_attempts_per_game") val free_throws_attempts_per_game: Float,
    @field:Json(name = "assists_per_game") val assists_per_game: Float,
    @field:Json(name = "offensive_rebounds_per_game") val offensive_rebounds_per_game: Float,
    @field:Json(name = "defensive_rebounds_per_game") val defensive_rebounds_per_game: Float,
    @field:Json(name = "steals_per_game") val steals_per_game: Float,
    @field:Json(name = "blocks_per_game") val blocks_per_game: Float,
    @field:Json(name = "turnovers_per_game") val turnovers_per_game: Float,
    @field:Json(name = "personal_fouls_per_game") val personal_fouls_per_game: Float,
    @field:Json(name = "OffRtg") val offRtg: Float,
    @field:Json(name = "Floor%") val floor: Float,
    @field:Json(name = "DefRtg") val defRtg: Float,
    @field:Json(name = "NetRtg") val netRtg: Float,
    @field:Json(name = "TS%") val tS: Float,
    @field:Json(name = "eFG%") val eFG: Float,
    @field:Json(name = "FTARate") val fTARate: Float,
    @field:Json(name = "3FGARate") val threeFGARate: Float,
    @field:Json(name = "OR%") val oR: Float,
    @field:Json(name = "DR%") val dR: Float,
    @field:Json(name = "BLK%") val bLK: Float,
    @field:Json(name = "TOV%") val tOV: Float,
    @field:Json(name = "AST%") val aST: Float,
    @field:Json(name = "STL%") val sTL: Float,
    @field:Json(name = "USG%") val uSG: Float,
    @field:Json(name = "team_id") val team_id: Int
)

data class PointsDistribution (
    @field:Json(name = "PG") val pg: Int,
    @field:Json(name = "SG") val sg: Int,
    @field:Json(name = "SF") val sf: Int,
    @field:Json(name = "PF") val pf: Int,
    @field:Json(name = "C") val c: Int
)

data class StarterSubDistribution(
    @field:Json(name = "PG_Subs") val pg_sub: Int,
    @field:Json(name = "PG_Starter") val pg_starter: Int,
    @field:Json(name = "SG_Subs") val sg_sub: Int,
    @field:Json(name = "SG_Starter") val sg_starter: Int,
    @field:Json(name = "SF_Subs") val sf_sub: Int,
    @field:Json(name = "SF_Starter") val sf_starter: Int,
    @field:Json(name = "PF_Subs") val pf_sub: Int,
    @field:Json(name = "PF_Starter") val pf_starter: Int,
    @field:Json(name = "C_Subs") val c_sub: Int,
    @field:Json(name = "C_Starter") val c_starter: Int
)

data class PointsDistributionData(
    @field:Json(name = "points_distribution") val pointsDistribution: PointsDistribution,
    @field:Json(name = "starters_sub_distribution") val starterSubDistribution: StarterSubDistribution
)

data class ClusterData(
    @field:Json(name = "failure") val failure: Int,
    @field:Json(name = "success") val success: Int
)

data class DefendData(
    @field:Json(name = "Cluster 0") val cluster0: ClusterData,
    @field:Json(name = "Cluster 1") val cluster1: ClusterData,
    @field:Json(name = "Cluster 2") val cluster2: ClusterData,
    @field:Json(name = "Cluster 3") val cluster3: ClusterData,
    @field:Json(name = "Cluster 4") val cluster4: ClusterData,
    @field:Json(name = "Cluster 5") val cluster5: ClusterData
)

data class DefendDataResponse(
    @field:Json(name = "player_data") val playerData: DefendData,
    @field:Json(name = "cluster_data") val clusterData: DefendData
)

data class InformResponse(
    @field:Json(name = "Local_TmOffRtg") val localOffRtg: Float,
    @field:Json(name = "Local_TmFloor%") val localFloor: Float,
    @field:Json(name = "Local_TmDefRtg") val localDefRtg: Float,
    @field:Json(name = "Local_Pace") val localPace: Float,
    @field:Json(name = "Local_TS%") val localTS: Float,
    @field:Json(name = "Local_eFG%") val localeFG: Float,
    @field:Json(name = "Local_FTARate") val localFTARate: Float,
    @field:Json(name = "Local_3FGARate") val local3FGARate: Float,
    @field:Json(name = "Local_TmOR%") val localOR: Float,
    @field:Json(name = "Local_TmDR%") val localDR: Float,
    @field:Json(name = "Local_BLK%") val localBLK: Float,
    @field:Json(name = "Local_TOV%") val localTOV: Float,
    @field:Json(name = "Local_STL%") val localSTL: Float,
    @field:Json(name = "Visitor_TmOffRtg") val visitorOffRtg: Float,
    @field:Json(name = "Visitor_TmFloor%") val visitorFloor: Float,
    @field:Json(name = "Visitor_TmDefRtg") val visitorDefRtg: Float,
    @field:Json(name = "Visitor_Pace") val visitorPace: Float,
    @field:Json(name = "Visitor_TS%") val visitorTS: Float,
    @field:Json(name = "Visitor_eFG%") val visitoreFG: Float,
    @field:Json(name = "Visitor_FTARate") val visitorFTARate: Float,
    @field:Json(name = "Visitor_3FGARate") val visitor3FGARate: Float,
    @field:Json(name = "Visitor_TmOR%") val visitorOR: Float,
    @field:Json(name = "Visitor_TmDR%") val visitorDR: Float,
    @field:Json(name = "Visitor_BLK%") val visitorBLK: Float,
    @field:Json(name = "Visitor_TOV%") val visitorTOV: Float,
    @field:Json(name = "Visitor_STL%") val visitorSTL: Float,
    @field:Json(name = "Local_Prediction") val localPrediction: String,
    @field:Json(name = "Visitor_Prediction") val visitorPrediction: String
)

data class BestDefendersResponse(
    @field:Json(name = "PG") val pg_name: String,
    @field:Json(name = "OpPG") val op_pg_name: String,
    @field:Json(name = "SG") val sg_name: String,
    @field:Json(name = "OpSG") val op_sg_name: String,
    @field:Json(name = "SF") val sf_name: String,
    @field:Json(name = "OpSF") val op_sf_name: String,
    @field:Json(name = "PF") val pf_name: String,
    @field:Json(name = "OpPF") val op_pf_name: String,
    @field:Json(name = "C") val c_name: String,
    @field:Json(name = "OpC") val op_c_name: String
)
