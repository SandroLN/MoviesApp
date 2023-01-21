package com.sandroln.moviesapp.movies.data

import com.sandroln.moviesapp.movies.domain.HandleError
import com.sandroln.moviesapp.movies.domain.Movies

interface HandleDataRequest {

    suspend fun handle(block: suspend () -> MovieData): Movies

    class Base(
        private val cacheDataSource: MoviesCacheDataSource,
        private val mapperToDomain: MovieData.Mapper<Movies>,
        private val handleError: HandleError<Exception>
    ) : HandleDataRequest {

        override suspend fun handle(block: suspend () -> MovieData) = try {
            val result = block.invoke()
            cacheDataSource.saveMovie(result)
            result.map(mapperToDomain)
        } catch (e: Exception) {
            throw handleError.handle(e)
        }
    }
}