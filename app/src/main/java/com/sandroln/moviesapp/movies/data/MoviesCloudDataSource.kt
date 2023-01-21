package com.sandroln.moviesapp.movies.data


interface MoviesCloudDataSource: FetchMovies {

    suspend fun init(): MovieData
}