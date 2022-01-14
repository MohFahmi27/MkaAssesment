package com.mohfahmi.mkaassesment.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersGithubEntity(
    val login: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int,
    val fullName: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
): Parcelable