package com.android.common_util

import android.util.Log

sealed class Result<T> {
    data class Success<T>(val data: T): Result<T>()
    data class Error<T>(val error: ErrorType): Result<T>()
}

sealed class ErrorType {
    sealed class Api: ErrorType() {
        object Network: Api()
        object ServiceUnavailable: Api()
        object NotFound: Api()
        object Server: Api()
    }
    object Unknown: ErrorType()
}

fun errorLog(errorMessage: String) {
    Log.d("yunje", "error: $errorMessage")
}

fun Throwable.mapError(): ErrorType =
    when(this) {
        is java.net.UnknownHostException -> ErrorType.Api.Network
        is retrofit2.HttpException -> when(this.code()) {
            404 -> ErrorType.Api.Network
            503 -> ErrorType.Api.ServiceUnavailable
            in 500..599 -> ErrorType.Api.Server
            else -> ErrorType.Api.NotFound
        }
        else -> ErrorType.Unknown
    }

fun ErrorType.mapErrorMessage() =
    when(this) {
        is ErrorType.Api.Network -> "Retrofit Network Error"
        is ErrorType.Api.ServiceUnavailable -> "Retrofit ServiceUnavailable error"
        is ErrorType.Api.NotFound -> "Retrofit NotFound Error"
        is ErrorType.Api.Server -> "Retrofit Server Error"
        is ErrorType.Unknown -> "Unknown Error"
    }