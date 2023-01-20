package com.sandroln.moviesapp.movies.presentation

import com.sandroln.moviesapp.movies.domain.Movies
import com.sandroln.moviesapp.movies.domain.MoviesResult

class MoviesResultMapper(
    private val communications: MoviesCommunication,
    private val mapper: Movies.Mapper<MovieUi>
) : MoviesResult.Mapper<Unit> {

    override fun map(list: List<Movies>, errorMessage: String) = communications.showState(
        if (errorMessage.isEmpty()) {
            val movieList = list.map { it.map(mapper) }
            if (movieList.isNotEmpty())
                communications.showList(movieList)
            UiState.Success()
        } else
            UiState.Error(errorMessage)
    )
}