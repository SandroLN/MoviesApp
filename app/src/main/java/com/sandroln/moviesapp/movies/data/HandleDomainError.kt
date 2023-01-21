package com.sandroln.moviesapp.movies.data

import com.sandroln.moviesapp.movies.domain.HandleError
import com.sandroln.moviesapp.movies.domain.NoInternetConnectionException
import com.sandroln.moviesapp.movies.domain.ServiceUnavailableException
import java.net.UnknownHostException

class HandleDomainError : HandleError<Exception> {

    override fun handle(e: Exception) = when (e) {
        is UnknownHostException -> NoInternetConnectionException()
        else -> ServiceUnavailableException()
    }
}
