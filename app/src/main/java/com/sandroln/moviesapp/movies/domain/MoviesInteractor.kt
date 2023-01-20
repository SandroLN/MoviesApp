package com.sandroln.moviesapp.movies.domain

interface MoviesInteractor {

    suspend fun init(): MoviesResult

    suspend fun movies(): MoviesResult
}