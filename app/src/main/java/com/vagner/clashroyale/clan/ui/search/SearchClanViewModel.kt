package com.vagner.clashroyale.clan.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vagner.clashroyale.clan.model.ClanModelItem
import com.vagner.clashroyale.clan.model.ClanModelResponse
import com.vagner.clashroyale.common.ClashRoyaleRepository
import com.vagner.clashroyale.common.Constants.ERROR
import com.vagner.clashroyale.common.Constants.NAME
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class SearchClanViewModel @Inject constructor(private val repository: ClashRoyaleRepository) :
    ViewModel() {

    val successRepository = MutableLiveData<List<ClanModelItem>>()
    val errorRepository = MutableLiveData<Any>()

    init {
        getAllClans()
    }

    fun getAllClans(name: String = NAME){
        repository.getAllClans(name).enqueue(object : retrofit2.Callback<ClanModelResponse> {
            override fun onResponse(
                call: Call<ClanModelResponse>,
                response: Response<ClanModelResponse>
            ) {
                response.body()?.let {
                    successRepository.postValue(it.items)
                }
            }

            override fun onFailure(call: Call<ClanModelResponse>, t: Throwable) {
                Log.d(ERROR, t.message.toString())
                errorRepository.postValue(t)
            }
        })
    }
}