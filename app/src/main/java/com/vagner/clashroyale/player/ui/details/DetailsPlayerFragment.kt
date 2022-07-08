package com.vagner.clashroyale.player.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.databinding.FragmentDetailsPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsPlayerFragment : BaseFragment<FragmentDetailsPlayerBinding, DetailsPlayerViewModel>() {

    override val viewModel: DetailsPlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsPlayerBinding =
        FragmentDetailsPlayerBinding.inflate(inflater, container, false)

}
