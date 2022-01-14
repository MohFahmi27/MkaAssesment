package com.mohfahmi.mkaassesment.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.usecase.UsersGithubUseCase

class DetailViewModel(private val usersGithubUseCase: UsersGithubUseCase) : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()

    fun getUserRepo(username: String): LiveData<ApiResponse<List<ReposResponseItem>>> {
        return usersGithubUseCase.getReposUserFromRepo(username)
    }
}