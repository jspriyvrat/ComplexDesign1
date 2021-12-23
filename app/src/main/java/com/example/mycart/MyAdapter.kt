package com.example.mycart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val roundImages:ArrayList<CircularImg>):RecyclerView.Adapter<MyAdapter.MyViewHolderInner>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderInner {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.verticalcard,parent,false)
        return MyViewHolderInner(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolderInner, position: Int) {
        val currentItem=roundImages[position]
        holder.titleimgs.setImageResource(currentItem.imgaes)
        holder.title.text=currentItem.title

    }

    override fun getItemCount(): Int {
      return roundImages.size
    }
    class MyViewHolderInner(itemView:View) : RecyclerView.ViewHolder(itemView) {
    val titleimgs:ImageView=itemView.findViewById(R.id.myverticalimage)
    val title:TextView=itemView.findViewById(R.id.verticaltext)



    }

}