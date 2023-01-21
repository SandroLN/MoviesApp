package com.sandroln.moviesapp.movies.data

import com.sandroln.moviesapp.movies.domain.Movies

class MovieDataToDomain : MovieData.Mapper<Movies> {
    override fun map(id: String, name: String) = Movies(id, name)
}