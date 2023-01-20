package com.sandroln.moviesapp.movies.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface MoviesCommunication : ObserveMovies {

    fun showProgress(show: Boolean)

    fun showState(uiState: UiState)

    fun showList(list: List<MovieUi>)

    class Base(
        private val progress: ProgressCommunication,
        private val state: MoviesStateCommunication,
        private val moviesList: MoviesListCommunication
    ) : MoviesCommunication {

        override fun showProgress(show: Boolean) = progress.map(show)

        override fun showState(uiState: UiState) = state.map(uiState)

        override fun showList(list: List<MovieUi>) = moviesList.map(list)

        override fun observeProgress(owner: LifecycleOwner, observer: Observer<Boolean>) =
            progress.observe(owner, observer)


        override fun observeState(owner: LifecycleOwner, observer: Observer<UiState>) =
            state.observe(owner, observer)

        override fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>) =
            moviesList.observe(owner, observer)
    }
}

interface ObserveMovies {

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Boolean>)

    fun observeState(owner: LifecycleOwner, observer: Observer<UiState>)

    fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>)
}

interface ProgressCommunication : Communication.Mutable<Boolean> {
    class Base() : Communication.Post<Boolean>(), ProgressCommunication
}


interface MoviesStateCommunication : Communication.Mutable<UiState> {
    class Base() : Communication.Post<UiState>(), MoviesStateCommunication
}

interface MoviesListCommunication : Communication.Mutable<List<MovieUi>> {
    class Base() : Communication.Post<List<MovieUi>>(), MoviesListCommunication
}