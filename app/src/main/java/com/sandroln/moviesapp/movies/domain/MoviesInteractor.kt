package com.sandroln.moviesapp.movies.domain

interface MoviesInteractor {

    suspend fun init(): MoviesResult

    suspend fun movie(id: String): MoviesResult

    class Base(
        private val repository: MoviesRepository,
        private val handleRequest: HandleRequest
    ) : MoviesInteractor {

        override suspend fun init() = MoviesResult.Success(repository.allMovies())


        override suspend fun movie(id: String): MoviesResult = handleRequest.handle {
            repository.movie(id)
        }
    }
}