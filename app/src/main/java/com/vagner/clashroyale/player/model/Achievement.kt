package com.vagner.clashroyale.player.model

data class Achievement(
    val completionInfo: Any,
    val info: String,
    val name: String,
    val stars: Int,
    val target: Int,
    val value: Int
)