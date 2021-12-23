package com.example.mycart

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class IntroSlideAdapter(private val introslides:List<IntroSlide>):
    RecyclerView.Adapter<IntroSlideAdapter.InnerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        return InnerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sliders,parent,false)
        )
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
            holder.bind(introslides[position])
    }

    override fun getItemCount(): Int {
      return introslides.size
    }
    inner class InnerViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        private val image:ImageView=view.findViewById(R.id.mysliderimgae)

        fun  bind(introSlide:IntroSlide)
        {
            image.setImageResource(introSlide.icon)
        }

    }
}