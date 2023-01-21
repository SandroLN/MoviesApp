package com.sandroln.moviesapp.movies.domain

import com.sandroln.moviesapp.R
import com.sandroln.moviesapp.movies.presentation.ManageResources

interface HandleError<T> {

    fun handle(e: Exception): T

    class Base(private val manageResources: ManageResources) : HandleError<String> {
        override fun handle(e: Exception) = manageResources.string(
            when (e) {
                is NoInternetConnectionException -> R.string.no_connection_message
                else -> R.string.service_is_unavailable
            }
        )
    }
}
