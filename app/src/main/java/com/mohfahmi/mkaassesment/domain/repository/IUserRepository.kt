package com.mohfahmi.mkaassesment.domain.repository

import androidx.lifecycle.LiveData
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity

interface IUserRepository {
    fun geDetailUserOnMainGithub(query: String): LiveData<ArrayList<UsersGithubEntity>>
    fun getDetailDataUserGithub(username: String): LiveData<ApiResponse<DetailResponse>>
    fun getReposUserGithub(username: String): LiveData<ApiResponse<List<ReposResponseItem>>>
}