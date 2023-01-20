package com.sandroln.moviesapp.movies.domain

import com.sandroln.moviesapp.movies.presentation.MovieUi

class MovieUiMapper: Movies.Mapper<MovieUi> {
    override fun map(id: String, name: String): MovieUi = MovieUi(id, name)
}