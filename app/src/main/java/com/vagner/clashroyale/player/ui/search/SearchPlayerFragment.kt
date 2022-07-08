package com.vagner.clashroyale.player.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.databinding.FragmentSearchPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchPlayerFragment : BaseFragment<FragmentSearchPlayerBinding, SearchPlayerViewModel>() {

    override val viewModel: SearchPlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchPlayerBinding =
        FragmentSearchPlayerBinding.inflate(inflater, container, false)


}
