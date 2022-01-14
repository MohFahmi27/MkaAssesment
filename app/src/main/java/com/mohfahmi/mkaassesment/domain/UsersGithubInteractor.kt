package com.mohfahmi.mkaassesment.domain

import androidx.lifecycle.LiveData
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import com.mohfahmi.mkaassesment.domain.repository.IUserRepository
import com.mohfahmi.mkaassesment.domain.usecase.UsersGithubUseCase

class UsersGithubInteractor(private val userRepositoryInterface: IUserRepository) :
    UsersGithubUseCase {
    override fun geDetailUserOnMainGithub(query: String): LiveData<ArrayList<UsersGithubEntity>> =
        userRepositoryInterface.geDetailUserOnMainGithub(query)

    override fun getDetailDataUserFromRepo(username: String): LiveData<ApiResponse<DetailResponse>> =
        userRepositoryInterface.getDetailDataUserGithub(username)

    override fun getReposUserFromRepo(username: String): LiveData<ApiResponse<List<ReposResponseItem>>> =
        userRepositoryInterface.getReposUserGithub(username)

}