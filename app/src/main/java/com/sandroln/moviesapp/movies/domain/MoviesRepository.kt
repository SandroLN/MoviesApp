package com.sandroln.moviesapp.movies.domain

interface MoviesRepository {

    suspend fun allMovies(): List<Movies>

    suspend fun movie(id: String): Movies
}