package com.example.gamelist;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barbbecker.fundatec.apirestful.MainActivity
import com.barbbecker.fundatec.apirestful.Post
import com.barbbecker.fundatec.apirestful.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_layout.view.*

class CustomAdapter(var context: Context, var apiList: java.util.ArrayList<Post>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)
        return ViewHolder(v, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(apiList[position])
    }


    override fun getItemCount(): Int {
        return apiList.size
    }

    fun updateList(list: ArrayList<Post>) {
        apiList = list
        notifyDataSetChanged()

    }

    fun clearList() {
        apiList.clear()
        notifyDataSetChanged()
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View, var ctx: Context) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Post) {
            itemView.textName.text = item.name
            itemView.textUsername.text = item.username
            Picasso.get().load(item.image).fit().centerCrop().into(itemView.imagePhoto)
            itemView.textLike.text = item.likes.toString()
            itemView.textDescribe.text = item.desc
            itemView.btExcluir.setOnClickListener { view ->
                if (ctx is MainActivity) {
                    (ctx as MainActivity).deletePost(item.id)
                }
            }
            itemView.imageLike.setOnClickListener { view ->
                if (ctx is MainActivity) {
                    (ctx as MainActivity).likePost(item.id)
                }
            }
            itemView.imagePhoto.setOnLongClickListener{view ->
                if (ctx is MainActivity) {
                    (ctx as MainActivity).likePost(item.id)
                }
                true
            }
        }
    }
}