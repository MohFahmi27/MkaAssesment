package com.mohfahmi.mkaassesment.ui.home

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohfahmi.mkaassesment.R
import com.mohfahmi.mkaassesment.databinding.FragmentHomeBinding
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import com.mohfahmi.mkaassesment.ui.adapter.UsersMainActAdapter
import com.mohfahmi.mkaassesment.utils.ViewUtils.stateConfig
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModel()
    private val usersAdapter: UsersMainActAdapter by lazy {
        UsersMainActAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvUsersMain.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvUsersMain.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            rvUsersMain.adapter = usersAdapter

            searchView.setOnQueryTextListener(object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.isLoading.value = true
                    query?.let {
                        if (it.isNotEmpty()) {
                            viewModel.searchUsersGithubMain(query)
                                .observe(requireActivity()) { result ->
                                    usersAdapter.listItems = result as ArrayList<UsersGithubEntity>
                                    viewModel.isLoading.value = false
                                }
                        }
                    }
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean = true
            })

            usersAdapter.onItemClick = { user ->
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        user
                    )
                )
            }
        }

        viewModel.isLoading.observe(requireActivity()) {
            binding.pgrMain.stateConfig(it)
        }
    }
}