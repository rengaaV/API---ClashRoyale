package com.vagner.clashroyale.player.model

data class Badge(
    val iconUrls: IconUrls,
    val level: Int,
    val maxLevel: Int,
    val name: String,
    val progress: Int,
    val target: Int
)