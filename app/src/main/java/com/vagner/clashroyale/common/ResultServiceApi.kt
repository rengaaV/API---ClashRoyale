package com.vagner.clashroyale.common

sealed class ResultServiceApi<out R> {
    data class Success<out T>(val dado: T?) : ResultServiceApi<T?>()
    data class Error(val exception: Exception) : ResultServiceApi<Nothing>()
}