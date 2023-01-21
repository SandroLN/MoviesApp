package com.sandroln.moviesapp.movies.data


data class MovieData(
    private val id: String,
    private val name: String
) {
    interface Mapper<T> {
        fun map(id: String, name: String): T

        class Matches(private val id: String) : Mapper<Boolean> {
            override fun map(id: String, name: String) = this.id == id
        }
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, name)
}
