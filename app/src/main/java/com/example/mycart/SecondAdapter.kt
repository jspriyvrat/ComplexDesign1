package com.example.mycart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SecondAdapter(private val roundImages:ArrayList<MyData>): RecyclerView.Adapter<SecondAdapter.MyViewHolderInner>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderInner {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.myimagecard,parent,false)
        return MyViewHolderInner(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolderInner, position: Int) {
        val currentItem=roundImages[position]
        holder.titleimg.setImageResource(currentItem.myimage)
        holder.title.text=currentItem.mytitle

    }

    override fun getItemCount(): Int {
        return roundImages.size
    }
    class MyViewHolderInner(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleimg: ImageView =itemView.findViewById(R.id.myimagehorizontal)
        val title: TextView =itemView.findViewById(R.id.texthorizontal)



    }

}