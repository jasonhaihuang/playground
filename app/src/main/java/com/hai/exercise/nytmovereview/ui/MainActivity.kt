package com.hai.exercise.nytmovereview.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import com.hai.exercise.nytmovereview.R
import com.hai.exercise.nytmovereview.model.Review
import com.hai.exercise.nytmovereview.model.ReviewViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    internal val LOG_TAG = MainActivity::class.java.simpleName
    internal val mContext:Context

    init {
        mContext = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The observer observs the live data provided by the view model, any data updates will trigger the
        //observer to update the data in recycler view adapter and UI refresh.
        val observer:Observer<Pair<Response, Result<Review, FuelError>>> = Observer {
            if (it != null){
                when (it.second) {
                    is com.github.kittinunf.result.Result.Failure -> {
                        println("result is: $it")
                        Toast.makeText(this, "Fail to fetch data: ${it.second}", Toast.LENGTH_LONG).show()
                        Log.e(LOG_TAG, "FUEL HTTP ERROR: $it")
                    }
                    is com.github.kittinunf.result.Result.Success -> {
                        val data = it.second.get()
                        (main_listView.adapter as ReviewListAdapter).setData(data.results)
                        (main_listView.adapter as ReviewListAdapter).notifyDataSetChanged()
                        Log.e(LOG_TAG, "FUEL HTTP RESPONSE: $data")
                    }
                }
            }

            //when network request finished, set button visible, hide progress bar
            main_btnQuery.visibility = View.VISIBLE
            main_progressBar.visibility = View.INVISIBLE
        }

        //initially, set button invisible, display progress bar
        main_btnQuery.visibility = View.INVISIBLE
        main_progressBar.visibility = View.VISIBLE

        //Get a view model object by class
        val mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ReviewViewModel::class.java)
        mViewModel.getReview().observe(this, observer)

        main_btnQuery.setOnClickListener {
            if (!main_etQueryString.text.isNullOrEmpty()){
                mViewModel.queryReview(main_etQueryString.text.toString()).observe(this, observer)

                //when starting retrieve data from network, set button invisible, display progress bar
                main_btnQuery.visibility = View.INVISIBLE
                main_progressBar.visibility = View.VISIBLE
            }else{
                Toast.makeText(this, "Please input a query string.", Toast.LENGTH_SHORT).show()
            }
        }

        //init the recycler view
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        main_listView.layoutManager = llm
        main_listView.adapter = ReviewListAdapter(this)
    }
}

