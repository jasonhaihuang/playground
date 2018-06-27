package com.hai.exercise.nytmovereview.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import com.hai.exercise.nytmovereview.repository.ReviewRepository

/**
 * The Review View Model holds all the movie review data, providing methods to UI for new query.
 */
class ReviewViewModel(application: Application) : AndroidViewModel(application) {

    //The LiveData of review. Any data change in the data will be notified to the UI by Observer.
    internal val data: LiveData<Pair<Response, Result<Review, FuelError>>>

    internal val repository: ReviewRepository

    init {
        repository = ReviewRepository(application)
        data = repository.queryReviews()
    }

    fun getReview() : LiveData<Pair<Response, Result<Review, FuelError>>>{
        return data
    }

    fun queryReview(queryString: String): LiveData<Pair<Response, Result<Review, FuelError>>>{
        return repository.queryReviews(queryString)
    }
}