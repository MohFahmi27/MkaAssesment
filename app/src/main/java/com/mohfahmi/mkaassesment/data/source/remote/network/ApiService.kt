package com.mohfahmi.mkaassesment.data.source.remote.network

import com.mohfahmi.mkaassesment.data.source.remote.network.ApiCredentials.API_KEY
import com.mohfahmi.mkaassesment.data.source.remote.response.DetailResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.data.source.remote.response.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token $API_KEY")
    fun getSearchDataGithub(
        @Query("q") query: String
    ): Call<SearchResponse>

    @GET("users/{username}")
    @Headers("Authorization: token $API_KEY")
    fun geDetailUserGithub(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/repos")
    @Headers("Authorization: token $API_KEY")
    fun getUserRepoGithub(
        @Path("username") username: String
    ): Call<List<ReposResponseItem>>
}