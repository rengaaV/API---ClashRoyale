package com.vagner.clashroyale.clan.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.databinding.FragmentSearchClanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchClanFragment : BaseFragment<FragmentSearchClanBinding,SearchClanViewModel>() {

    override val viewModel: SearchClanViewModel by viewModels()

    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // SearchView()
    }

    private fun SearchView() {
        searchView = binding.searchViewClan
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              // viewModel
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