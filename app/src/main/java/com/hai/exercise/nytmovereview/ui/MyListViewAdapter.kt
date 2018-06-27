package com.hai.exercise.nytmovereview.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hai.exercise.nytmovereview.R
import com.hai.exercise.nytmovereview.model.Result
import kotlinx.android.synthetic.main.main_reviewlist_item.view.*

/**
 * The adapter updates the data from view model to the recycler view
 *
 */
class ReviewListAdapter(ctx: Context) : RecyclerView.Adapter<CustomViewHolder>(){
    internal val LOG_TAG = ReviewListAdapter::class.java.simpleName

    val mCtx = ctx
    var reviewData : MutableList<Result> = arrayListOf()

    fun setData(data: List<Result>){
        reviewData.clear()
        reviewData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cell = layoutInflater.inflate(R.layout.main_reviewlist_item, parent, false)
        return CustomViewHolder(cell)
    }

    override fun getItemCount(): Int {
        return reviewData.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val review = reviewData.get(position)
        Log.d(LOG_TAG, "review is: $review")
        if (review != null) {
            holder.itemView.main_list_item_title.text = review.display_title
            holder.itemView.main_list_item_headline.text = review.headline
            holder.itemView.main_list_item_date.text = review.publication_date
            holder.itemView.main_list_item_image.setOnClickListener({
                if (review.link != null) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(review.link.url))
                    mCtx.startActivity(intent)
                }else{
                    Log.e(LOG_TAG, "no link found: ${review.link}")
                }
            })
            if (review.multimedia != null ) {
                Glide.with(mCtx)
                        .load(review.multimedia.src)
                        .into(holder.itemView.main_list_item_image)
            }else{
                Log.e(LOG_TAG, "no resource: ${review.multimedia}")
            }
        }
    }
}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)