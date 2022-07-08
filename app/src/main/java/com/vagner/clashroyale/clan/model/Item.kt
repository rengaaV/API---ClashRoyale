package com.vagner.clashroyale.clan.model

import java.io.Serializable

data class Item(
    val badgeId: Int,
    val clanChestLevel: Int,
    val clanChestMaxLevel: Int,
    val clanScore: Int,
    val clanWarTrophies: Int,
    val donationsPerWeek: Int,
    val location: Location,
    val members: Int,
    val name: String,
    val requiredTrophies: Int,
    val tag: String,
    val type: String
):Serializable