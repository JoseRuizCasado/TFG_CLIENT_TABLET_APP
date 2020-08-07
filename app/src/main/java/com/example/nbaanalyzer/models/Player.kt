package com.example.nbaanalyzer.models

data class Player(
    val id: Int,
    val name: String,
    val position: String,
    val played_games: Int,
    val mpg: Double,
    val ppg: Double,
    val or: Double,
    val dr: Double,
    val blk: Double,
    val tov: Double,
    val fgm: Double,
    val fga: Double,
    val fgp: Double,
    val threepm: Double,
    val threepa: Double,
    val threepp: Double,
    val threepr: Double,
    val twoopm: Double,
    val twoopa: Double,
    val twoopp: Double,
    val efficientfg: Double,
    val ftm: Double,
    val fta: Double,
    val ftp: Double
)