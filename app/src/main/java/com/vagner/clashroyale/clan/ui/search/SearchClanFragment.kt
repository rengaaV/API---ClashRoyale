package com.vagner.clashroyale.clan.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vagner.clashroyale.clan.adapter.ClanAdapter
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.common.Constants.NAME
import com.vagner.clashroyale.common.ResultServiceApi
import com.vagner.clashroyale.databinding.FragmentSearchClanBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DEBUG_PROPERTY_NAME

@AndroidEntryPoint
class SearchClanFragment :
    BaseFragment<FragmentSearchClanBinding, SearchClanViewModel>() {

    override val viewModel: SearchClanViewModel by viewModels()

    private lateinit var searchView: SearchView

    private val clanAdapter = ClanAdapter {
        val action =
            SearchClanFragmentDirections.actionSearchClanFragmentToDetailsClanFragment(it)
        findNavController().navigate(action)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        searchView()
        getClan(NAME)
    }

    private fun getClan(name : String) {
        viewModel.getClans(name).observe(viewLifecycleOwner) { resultado ->
            when (resultado) {
                is ResultServiceApi.Success -> {
                    resultado.dado?.let {
                        clanAdapter.clanList = it.items
                    }
                }
                is ResultServiceApi.Error -> {
                    Snackbar.make(
                        binding.rvClan,
                        resultado.exception.message.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvClan.apply {
            adapter = clanAdapter
            setHasFixedSize(true)
        }
    }


    private fun searchView() {
        searchView = binding.svClan
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(name: String): Boolean {
                 getClan(name)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchClanBinding =
        FragmentSearchClanBinding.inflate(inflater, container, false)
}