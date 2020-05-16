package com.example.nbaanalyzer.models

data class Player(
    val id: Int,
    val name: String,
    val position: String,
    val mpg: Double,
    val fgm: Double,
    val fga: Double,
    val fgp: Double,
    val threepm: Double,
    val threepa: Double,
    val threepp: Double,
    val twoopm: Double,
    val twoopa: Double,
    val twoopp: Double,
    val efficientfg: Double,
    val ftm: Double
)