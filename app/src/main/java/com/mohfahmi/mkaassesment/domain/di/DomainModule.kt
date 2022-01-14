package com.mohfahmi.mkaassesment.domain.di

import com.mohfahmi.mkaassesment.data.UserRepository
import com.mohfahmi.mkaassesment.data.source.remote.RemoteDataSource
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiCredentials
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiCredentials.BASE_URL
import com.mohfahmi.mkaassesment.data.source.remote.network.ApiService
import com.mohfahmi.mkaassesment.domain.repository.IUserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IUserRepository> { UserRepository(get()) }
}