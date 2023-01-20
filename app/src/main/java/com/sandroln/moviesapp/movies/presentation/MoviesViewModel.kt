package com.sandroln.moviesapp.movies.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sandroln.moviesapp.movies.domain.MoviesInteractor
import androidx.lifecycle.viewModelScope
import com.sandroln.moviesapp.R
import com.sandroln.moviesapp.movies.domain.MoviesResult
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val handleResult: HandleNumbersRequest,
    private val manageResources: ManageResources,
    private val communications: MoviesCommunication,
    private val interactor: MoviesInteractor,
) : ViewModel(), ObserveMovies, FetchMovies {

    override fun observeProgress(owner: LifecycleOwner, observer: Observer<Boolean>) {
        communications.observeProgress(owner, observer)
    }

    override fun observeState(owner: LifecycleOwner, observer: Observer<UiState>) {
        communications.observeState(owner, observer)
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>) {
        communications.observeList(owner, observer)
    }

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun) {
            handleResult.handle(viewModelScope){
                interactor.init()
            }
        }
    }

    override fun fetchMovies(name: String) {
        if (name.isEmpty())
            communications.showState(UiState.Error(manageResources.string(R.string.empty_name_error_message)))
        else handleResult.handle(viewModelScope){
            interactor.movies()
        }
    }
}

interface FetchMovies {

    fun init(isFirstRun: Boolean)

    fun fetchMovies(name: String)
}

