package com.mohfahmi.mkaassesment.data

import androidx.lifecycle.LiveData
import com.mohfahmi.mkaassesment.data.source.remote.RemoteDataSource
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import com.mohfahmi.mkaassesment.domain.repository.IUserRepository

class UserRepository(private val remoteDataSource: RemoteDataSource): IUserRepository {
    override fun geDetailUserOnMainGithub(query: String): LiveData<ArrayList<UsersGithubEntity>> {
        return remoteDataSource.getSearchUserOnMainGithub(query)
    }

    override fun getDetailDataUserGithub(username: String): LiveData<ApiResponse<DetailResponse>> {
        return remoteDataSource.getDetailDataUserGithub(username)
    }

    override fun getReposUserGithub(username: String): LiveData<ApiResponse<List<ReposResponseItem>>> {
        return remoteDataSource.getReposUserGithub(username)
    }
}