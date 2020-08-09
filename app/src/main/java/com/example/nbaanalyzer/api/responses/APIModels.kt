package com.example.nbaanalyzer.api.responses

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
    @field:Json(name = "TmDR%") val tmDR: Float,
    @field:Json(name = "BLK%") val bLK: Float,
    @field:Json(name = "TOV%") val tOV: Float,
    @field:Json(name = "AST%") val aST: Float,
    @field:Json(name = "STL%") val sTL: Float
)
