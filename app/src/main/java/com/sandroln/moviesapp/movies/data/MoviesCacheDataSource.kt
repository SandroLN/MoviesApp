package com.sandroln.moviesapp.movies.data

interface MoviesCacheDataSource: FetchMovies {

    suspend fun allMovies(): List<MovieData>

    suspend fun contains(id: String): Boolean

    suspend fun saveMovie(movieData: MovieData): MovieData
}

interface FetchMovies{
    suspend fun movie(id: String): MovieData
}