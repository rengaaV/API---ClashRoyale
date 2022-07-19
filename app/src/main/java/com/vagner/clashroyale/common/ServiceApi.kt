package com.vagner.clashroyale.common

import com.vagner.clashroyale.cards.model.CardsModelResponse
import com.vagner.clashroyale.clan.model.ClanModelResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("clans")
    fun getAllClans(@Query("name") name: String): Call<ClanModelResponse>

    @GET("cards")
    fun getAllCards(): Call<CardsModelResponse>
}