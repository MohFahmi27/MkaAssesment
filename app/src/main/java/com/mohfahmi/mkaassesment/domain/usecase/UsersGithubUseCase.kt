package com.mohfahmi.mkaassesment.domain.usecase

import androidx.lifecycle.LiveData
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity

interface UsersGithubUseCase {
    fun geDetailUserOnMainGithub(query: String): LiveData<ArrayList<UsersGithubEntity>>
    fun getDetailDataUserFromRepo(username: String): LiveData<ApiResponse<DetailResponse>>
    fun getReposUserFromRepo(username: String): LiveData<ApiResponse<List<ReposResponseItem>>>
}