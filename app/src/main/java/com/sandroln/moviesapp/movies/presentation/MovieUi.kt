package com.sandroln.moviesapp.movies.presentation

import android.widget.TextView

data class MovieUi(
    private val id: String,
    private val name: String
) {
    fun map(head: TextView, name: TextView){
        head.text = id
        name.text = this.name
    }
}