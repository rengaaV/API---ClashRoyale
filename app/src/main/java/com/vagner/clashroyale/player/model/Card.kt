package com.vagner.clashroyale.player.model

data class Card(
    val count: Int,
    val iconUrls: IconUrlsX,
    val id: Int,
    val level: Int,
    val maxLevel: Int,
    val name: String,
    val starLevel: Int
)