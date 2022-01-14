package com.mohfahmi.mkaassesment.ui.detail

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohfahmi.mkaassesment.R
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.data.source.remote.response.StatusResponse
import com.mohfahmi.mkaassesment.databinding.FragmentDetailBinding
import com.mohfahmi.mkaassesment.ui.adapter.ReposDetailActAdapter
import com.mohfahmi.mkaassesment.utils.ViewUtils.setRoundedGlide
import com.mohfahmi.mkaassesment.utils.ViewUtils.stateConfig
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding: FragmentDetailBinding by viewBinding()
    private val viewModel: DetailViewModel by viewModel()
    private val args: DetailFragmentArgs by navArgs()
    private val reposAdapter by lazy {
        ReposDetailActAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userDetail = args.userDataToDetail
        viewModel.isLoading.value = true

        with(binding) {
            rvRepoDetail.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvRepoDetail.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            rvRepoDetail.adapter = reposAdapter

            tvFullnameDetail.text = userDetail.fullName
            tvEmailDetail.text = userDetail.email
            tvDescriptionProfileDetail.text = userDetail.bio
            tvUsernameDetail.text = userDetail.login
            tvFollowersDetail.text =
                requireContext().getString(R.string.followers_format, userDetail.followers)
            tvFollowingDetail.text =
                requireContext().getString(R.string.following_format, userDetail.following)
            tvLocationDetail.text = userDetail.location
            imgProfileDetail.setRoundedGlide(userDetail.avatarUrl)
        }

        viewModel.getUserRepo(userDetail.login).observe(requireActivity()) {
            it?.let {
                when (it.status) {
                    StatusResponse.ERROR -> {
                        Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.isLoading.value = false
                    }
                    StatusResponse.EMPTY -> {
                        Toast.makeText(
                            requireContext(),
                            "No Repository",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.isLoading.value = false
                    }
                    StatusResponse.SUCCESS -> {
                        reposAdapter.repos = it.body as ArrayList<ReposResponseItem>
                        viewModel.isLoading.value = false
                    }
                }
            }
        }

        viewModel.isLoading.observe(requireActivity()) {
            binding.pgrDetail.stateConfig(it)
        }
    }
}