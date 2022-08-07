package com.vagner.clashroyale.common


import androidx.lifecycle.liveData
import com.vagner.clashroyale.common.Constants.ERROR
import java.net.ConnectException
import javax.inject.Inject

class ClashRoyaleRepository @Inject constructor(
    private val service: ServiceApi,
) {

   suspend fun getClans(name: String) = service.getClans(name)

   suspend fun getAllCards() = service.getAllCards()

}