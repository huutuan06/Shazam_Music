package com.tuannguyen.shazammusic.data.util

import com.tuannguyen.shazammusic.data.model.APIResponse
import retrofit2.Response

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}

fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
    if (response.isSuccessful) {
        response.body()?.let {
            return Resource.Success(it)
        }
    }
    return Resource.Error(response.message())
}

