package com.vagner.clashroyale.cards.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vagner.clashroyale.cards.adapter.CardsAdapter
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.common.Constants
import com.vagner.clashroyale.databinding.FragmentCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsFragment : BaseFragment<FragmentCardsBinding, CardsViewModel>() {
    override val viewModel: CardsViewModel by viewModels()

    private val cardsAdapter = CardsAdapter{}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        cardListObserver()
    }

    private fun cardListObserver() {
        successCardList()
        errorErrorList()
    }

    private fun successCardList() {
       viewModel.successRepository.observe(viewLifecycleOwner){
           cardsAdapter.cardList = it
       }
    }

    private fun errorErrorList() {
       viewModel.errorRepository.observe(viewLifecycleOwner){
           Toast.makeText(context, Constants.ERROR, Toast.LENGTH_LONG).show()
       }
    }

    private fun setupRecyclerView() {
       binding.rvCard.apply {
           adapter = cardsAdapter
           layoutManager = LinearLayoutManager(requireContext())
           setHasFixedSize(true)
       }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCardsBinding =
        FragmentCardsBinding.inflate(inflater, container, false)

}