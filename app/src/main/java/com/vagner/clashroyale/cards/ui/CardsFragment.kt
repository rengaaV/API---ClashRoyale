package com.vagner.clashroyale.cards.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.vagner.clashroyale.cards.adapter.CardsAdapter
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.common.ResultServiceApi
import com.vagner.clashroyale.databinding.FragmentCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsFragment : BaseFragment<FragmentCardsBinding, CardsViewModel>() {
    override val viewModel: CardsViewModel by viewModels()

    private val cardsAdapter = CardsAdapter {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        getAllCards()
    }

    private fun getAllCards() {
        viewModel.getAllCards().observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResultServiceApi.Success -> {
                    result.dado?.let {
                        cardsAdapter.cardList = it.items
                    }
                }
                is ResultServiceApi.Error -> {
                    Snackbar.make(binding.rvCard,
                        result.exception.message.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun setupRecyclerView() {
        binding.rvCard.apply {
            adapter = cardsAdapter
            setHasFixedSize(true)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCardsBinding =
        FragmentCardsBinding.inflate(inflater, container, false)

}