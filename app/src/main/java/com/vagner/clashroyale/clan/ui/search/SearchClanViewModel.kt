package com.vagner.clashroyale.clan.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vagner.clashroyale.clan.model.ClanModelResponse
import com.vagner.clashroyale.common.ClashRoyaleRepository
import com.vagner.clashroyale.common.Constants
import com.vagner.clashroyale.common.ResultServiceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.ConnectException
import javax.inject.Inject


@HiltViewModel
class SearchClanViewModel @Inject constructor(private val repository: ClashRoyaleRepository) :
    ViewModel() {


    fun getClans(name: String): LiveData<ResultServiceApi<ClanModelResponse?>> = liveData {
        try {
            val response = repository.getClans(name)
            if (response.isSuccessful) {
                emit(ResultServiceApi.Success(dado = response.body()))
            } else {
                emit(ResultServiceApi.Error(exception = Exception(Constants.ERROR)))
            }
        } catch (e: ConnectException) {
            emit(ResultServiceApi.Error(exception = Exception("Falha na comunicação com API")))

        } catch (e: Exception) {
            emit(ResultServiceApi.Error(exception = e))
        }
    }
}