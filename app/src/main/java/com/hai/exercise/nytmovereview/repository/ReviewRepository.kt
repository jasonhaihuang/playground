package com.hai.exercise.nytmovereview.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.livedata.liveDataResponseObject
import com.hai.exercise.nytmovereview.model.Review

/**
 * The repository send request to the server and return an Livedata object to View Model.
 *
 * For more complicate scenario, the repository can have logic to check local cache first, return local data
 * to View Model if it exists. Then the repository send request to server to get the latest data. After receiving
 * the new data, save it to local cache.
 *
 * The local cache data update should trigger the view model to notify the observer.
 *
 */
class ReviewRepository(ctx: Context) {

    internal val mContext: Context

    init {
        mContext = ctx
    }

    /**
     * Here we are using FUEL library to send Http request.
     */
    fun queryReviews(keywords: String = "") : LiveData<Pair<Response, com.github.kittinunf.result.Result<Review, FuelError>>> {
        //if you prefer this a little longer way, you can always do get
        FuelManager.instance.basePath = "https://api.nytimes.com/svc/movies/v2"
        FuelManager.instance.baseParams = listOf("api-key" to "42196657ab164a5d84366d3f05096d06", "query" to keywords)
        return Fuel.get("/reviews/search.json").liveDataResponseObject(Review.Deserializer())
    }
}