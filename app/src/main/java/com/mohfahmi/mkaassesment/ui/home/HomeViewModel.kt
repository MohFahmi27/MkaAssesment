package com.mohfahmi.mkaassesment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.SearchResponse
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import com.mohfahmi.mkaassesment.domain.usecase.UsersGithubUseCase

class HomeViewModel(private val usersGithubUseCase: UsersGithubUseCase) : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()

    fun searchUsersGithubMain(query: String): LiveData<ArrayList<UsersGithubEntity>> =
        usersGithubUseCase.geDetailUserOnMainGithub(query)
}