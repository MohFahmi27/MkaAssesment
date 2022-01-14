package com.mohfahmi.mkaassesment.di

import com.mohfahmi.mkaassesment.domain.UsersGithubInteractor
import com.mohfahmi.mkaassesment.domain.usecase.UsersGithubUseCase
import com.mohfahmi.mkaassesment.ui.detail.DetailViewModel
import com.mohfahmi.mkaassesment.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UsersGithubUseCase> { UsersGithubInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}