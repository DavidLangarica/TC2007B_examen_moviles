package com.david.tmdbapp.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.tmdbapp.domain.MoviesListRequirement
import com.david.tmdbapp.domain.model.tmdbObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
 * Class that defines the ViewModel for the MoviesFragment
 */
class MoviesViewModel() : ViewModel() {
    val moviesObjectLiveData = MutableLiveData<tmdbObject?>()
    private val moviesListRequirement = MoviesListRequirement()

    /*
     * Function that makes the request to the API
     *
     * @param apiKey: String
     */
    fun getMoviesList(apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result: tmdbObject? = moviesListRequirement(apiKey)
            if (result == null) {
                Log.d("Salida", "result is null")
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    moviesObjectLiveData.postValue(result)
                }
            }
        }
    }
}