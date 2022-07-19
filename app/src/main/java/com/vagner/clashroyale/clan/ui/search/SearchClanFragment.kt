package com.vagner.clashroyale.clan.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.vagner.clashroyale.clan.adapter.ClanAdapter
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.common.Constants
import com.vagner.clashroyale.databinding.FragmentSearchClanBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchClanFragment :
    BaseFragment<FragmentSearchClanBinding, SearchClanViewModel>() {

    override val viewModel: SearchClanViewModel by viewModels()

    private lateinit var searchView: SearchView

    private val clanAdapter = ClanAdapter { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        clanListObserver()
        searchView()
    }

    private fun setupRecyclerView() {
        binding.recyclerSearchClan.apply {
            adapter = clanAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun clanListObserver() {
        successClanList()
        errorClanList()
    }

    private fun errorClanList() {
        viewModel.errorRepository.observe(viewLifecycleOwner) {
            Toast.makeText(context, Constants.ERROR, Toast.LENGTH_LONG).show()
        }
    }

    private fun successClanList() {
        viewModel.successRepository.observe(viewLifecycleOwner) {
            clanAdapter.clanList = it
        }
    }

    private fun searchView() {
        searchView = binding.searchViewClan
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(name: String): Boolean {
                viewModel.getAllClans(name)
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