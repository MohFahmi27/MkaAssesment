package com.mohfahmi.mkaassesment.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiResponse
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiService
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.net.UnknownHostException

class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource {

    override fun getSearchUserOnMainGithub(query: String): LiveData<ArrayList<UsersGithubEntity>> {
        val usersResults = MutableLiveData<ArrayList<UsersGithubEntity>>()
        val usersResult = ArrayList<UsersGithubEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getSearchDataGithub(query).awaitResponse()
            if (response.isSuccessful) {
                response.body()?.items.let {
                    it?.forEach { user ->
                        val responseDetail =
                            apiService.geDetailUserGithub(user.login).awaitResponse()
                                .body() as DetailResponse
                        usersResult.add(
                            UsersGithubEntity(
                                responseDetail.login,
                                responseDetail.avatarUrl,
                                responseDetail.followers,
                                responseDetail.following,
                                responseDetail.name,
                                responseDetail.location,
                                responseDetail.email,
                                responseDetail.bio)
                        )
                    }
                    usersResults.postValue(usersResult)
                }
            }
        }
        return usersResults
    }

    override fun getDetailDataUserGithub(username: String): LiveData<ApiResponse<DetailResponse>> {
        val detailUserResults = MutableLiveData<ApiResponse<DetailResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.geDetailUserGithub(username).awaitResponse()
            try {
                if (response.isSuccessful) {
                    response.body()?.let {
                        detailUserResults.postValue(ApiResponse.success(it))
                    }
                } else {
                    ApiResponse.empty(response.message(), response.body())
                }
            } catch (e: HttpException) {
                ApiResponse.error(response.message(), response.body())
            } catch (e: UnknownHostException) {
                ApiResponse.error(response.message(), response.body())
            } catch (e: Throwable) {
                ApiResponse.error("Something went wrong", null)
            }
        }
        return detailUserResults
    }

    override fun getReposUserGithub(username: String): LiveData<ApiResponse<List<ReposResponseItem>>> {
        val reposUserResults = MutableLiveData<ApiResponse<List<ReposResponseItem>>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getUserRepoGithub(username).awaitResponse()
            try {
                if (response.isSuccessful) {
                    response.body()?.let {
                        reposUserResults.postValue(ApiResponse.success(it))
                    }
                } else {
                    ApiResponse.empty(response.message(), response.body())
                }
            } catch (e: HttpException) {
                ApiResponse.error(response.message(), response.body())
            } catch (e: UnknownHostException) {
                ApiResponse.error(response.message(), response.body())
            } catch (e: Throwable) {
                ApiResponse.error("Something went wrong", null)
            }
        }
        return reposUserResults
    }
}