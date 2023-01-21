package com.sandroln.moviesapp.movies.presentation

import com.sandroln.moviesapp.movies.domain.MoviesResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface HandleMoviesRequest {

    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> MoviesResult
    )

    class Base(
        private val dispatchers: DispatchersList,
        private val communications: MoviesCommunication,
        private val moviesResultMapper: MoviesResult.Mapper<Unit>,
    ) : HandleMoviesRequest {

        override fun handle(
            coroutineScope: CoroutineScope,
            block: suspend () -> MoviesResult
        ) {
            communications.showProgress(true)
            coroutineScope.launch(dispatchers.io()) {
                val result = block.invoke()
                communications.showProgress(false)
                result.map(moviesResultMapper)
            }
        }
    }
}