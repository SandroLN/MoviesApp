package com.sandroln.moviesapp.movies.domain

sealed class MoviesResult {

    interface Mapper<T> {
        fun map(list: List<Movies>, errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    class Success(private val list: List<Movies>) : MoviesResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(list, "")
    }

    class Failure(private val message: String) : MoviesResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(emptyList(), message)
    }
}