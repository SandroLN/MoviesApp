package com.sandroln.moviesapp.movies.domain

interface HandleRequest {

    suspend fun handle(block: suspend () -> Unit): MoviesResult

    class Base(
        private val handleError: HandleError,
        private val repository: MoviesRepository
    ) : HandleRequest {

        override suspend fun handle(block: suspend () -> Unit) = try {
            block.invoke()
            MoviesResult.Success(repository.allMovies())
        } catch (e: Exception) {
            MoviesResult.Failure(handleError.handle(e))
        }
    }
}