package com.sandroln.moviesapp.movies.domain

data class Movies(
    private val id: String,
    private val name: String
) {
    interface Mapper<T> {
        fun map(id: String, name: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name)
}

