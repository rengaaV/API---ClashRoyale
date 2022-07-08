package com.vagner.clashroyale.clan.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vagner.clashroyale.common.BaseFragment
import com.vagner.clashroyale.databinding.FragmentDetailsClanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsClanFragment : BaseFragment<FragmentDetailsClanBinding , DetailsClanViewModel>() {
    override val viewModel: DetailsClanViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsClanBinding =
        FragmentDetailsClanBinding.inflate(inflater, container, false)


}
