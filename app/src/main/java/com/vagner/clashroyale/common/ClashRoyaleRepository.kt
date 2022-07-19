package com.vagner.clashroyale.common

import javax.inject.Inject

class ClashRoyaleRepository @Inject constructor(
    private val api: ServiceApi,
) {

    fun getAllClans(name: String) = api.getAllClans(name)
    fun getAllCards() = api.getAllCards()

}