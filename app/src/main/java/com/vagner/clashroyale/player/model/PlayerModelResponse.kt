package com.vagner.clashroyale.player.model

import java.io.Serializable

data class PlayerModelResponse(
    val achievements: List<Achievement>,
    val arena: Arena,
    val badges: List<Badge>,
    val battleCount: Int,
    val bestTrophies: Int,
    val cards: List<Card>,
    val challengeCardsWon: Int,
    val challengeMaxWins: Int,
    val clan: Clan,
    val clanCardsCollected: Int,
    val currentDeck: List<CurrentDeck>,
    val currentFavouriteCard: CurrentFavouriteCard,
    val donations: Int,
    val donationsReceived: Int,
    val expLevel: Int,
    val expPoints: Int,
    val leagueStatistics: LeagueStatistics,
    val losses: Int,
    val name: String,
    val role: String,
    val starPoints: Int,
    val tag: String,
    val threeCrownWins: Int,
    val totalDonations: Int,
    val tournamentBattleCount: Int,
    val tournamentCardsWon: Int,
    val trophies: Int,
    val warDayWins: Int,
    val wins: Int
):Serializable