package com.vagner.clashroyale.cards.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.vagner.clashroyale.cards.model.CardsModelResponse
import com.vagner.clashroyale.cards.model.Item
import com.vagner.clashroyale.common.ClashRoyaleRepository
import com.vagner.clashroyale.common.Constants.ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor (private val repository: ClashRoyaleRepository) : ViewModel() {

    val successRepository = MutableLiveData<List<Item>>()
    val errorRepository = MutableLiveData<Any>()

    init {
        getAllCards()
    }

    fun getAllCards() {
        repository.getAllCards().enqueue(object : Callback<CardsModelResponse> {
            override fun onResponse(
                call: Call<CardsModelResponse>,
                response: Response<CardsModelResponse>
            ) {
                response.body()?.let {
                    successRepository.postValue(it.items)
                }
            }

            override fun onFailure(call: Call<CardsModelResponse>, t: Throwable) {
                Log.d(ERROR, t.message.toString())
                errorRepository.postValue(t)
            }

        })
    }
}