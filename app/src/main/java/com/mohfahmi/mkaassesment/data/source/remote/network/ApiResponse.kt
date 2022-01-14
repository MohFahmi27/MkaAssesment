package com.mohfahmi.mkaassesment.data.source.remote.network

import com.mohfahmi.mkaassesment.data.source.remote.response.StatusResponse
import com.mohfahmi.mkaassesment.data.source.remote.response.StatusResponse.*

class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(SUCCESS, body, null)
        fun <T> empty(msg: String, body: T): ApiResponse<T> = ApiResponse(EMPTY, body, msg)
        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(ERROR, body, msg)
    }
}