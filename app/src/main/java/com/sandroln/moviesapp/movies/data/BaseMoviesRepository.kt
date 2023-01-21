package com.sandroln.moviesapp.movies.data

import com.sandroln.moviesapp.movies.domain.Movies
import com.sandroln.moviesapp.movies.domain.MoviesRepository


class BaseMoviesRepository(
    private val cloudDataSource: MoviesCloudDataSource,
    private val cacheDataSource: MoviesCacheDataSource,
    private val mapperToDomain: MovieData.Mapper<Movies>,
    private val handleDataRequest: HandleDataRequest
) : MoviesRepository {

    override suspend fun allMovies(): List<Movies> {
        val data = cacheDataSource.allMovies()
        return data.map { it.map(mapperToDomain) }
    }

    override suspend fun movie(id: String) = handleDataRequest.handle {
        val datasource = if (cacheDataSource.contains(id))
            cacheDataSource
        else
            cloudDataSource
        datasource.movie(id)
    }
}
