package com.vagner.clashroyale.cards.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vagner.clashroyale.cards.model.CardsModelResponse
import com.vagner.clashroyale.common.ClashRoyaleRepository
import com.vagner.clashroyale.common.Constants
import com.vagner.clashroyale.common.ResultServiceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(private val repository: ClashRoyaleRepository) :
    ViewModel() {

    init {
        getAllCards()
    }

    fun getAllCards(): LiveData<ResultServiceApi<CardsModelResponse?>> = liveData {
        try {
            val response = repository.getAllCards()
            if (response.isSuccessful) {
                emit(ResultServiceApi.Success(response.body()))
            } else {
                emit(ResultServiceApi.Error(Exception(Constants.ERROR)))
            }
        } catch (e: ConnectException) {
            emit(ResultServiceApi.Error(exception = Exception("Falha na comunicação com API")))

        } catch (e: Exception) {
            emit(ResultServiceApi.Error(exception = e))
        }
    }
}