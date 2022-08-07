package com.vagner.clashroyale.common

import com.vagner.clashroyale.cards.model.CardsModelResponse
import com.vagner.clashroyale.clan.model.ClanModelResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("clans")
   suspend fun getClans(@Query("name") name: String): Response<ClanModelResponse>

    @GET("cards")
    suspend fun getAllCards(): Response<CardsModelResponse>
}