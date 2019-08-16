package com.example.gamelist;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barbbecker.fundatec.apifilmes.Movie
import com.barbbecker.fundatec.apifilmes.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_movie.view.*

class CustomAdapter(var context: Context, var movieList: ArrayList<Movie>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(v, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(movieList[position])
    }


    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateList(list: ArrayList<Movie>) {
        movieList = list
        notifyDataSetChanged()

    }

    fun clearList() {
        movieList.clear()
        notifyDataSetChanged()
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View, var ctx: Context) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Movie) {

            itemView.textTitle.text = item.title
            itemView.textYear.text = item.year
            Picasso.get().load(item.poster).fit().centerCrop().into(itemView.imagePoster)

            itemView.setOnClickListener {
                // Toast the values
                Toast.makeText(
                    ctx,
                    "Position :$adapterPosition\nItem Value : $item", Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }
}