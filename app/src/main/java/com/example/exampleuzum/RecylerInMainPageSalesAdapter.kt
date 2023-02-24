package com.example.exampleuzum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dataclassesForUse.ImgForBanner

class RecylerInMainPageSalesAdapter :
    RecyclerView.Adapter<RecylerInMainPageSalesAdapter.SalesViewHolder>() {
    private var imgList = mutableListOf<ImgForBanner>()

    fun setImages(items: List<ImgForBanner>) {
        imgList.clear()
        imgList.addAll(items)
         notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyler_view_in_main_page_sales, parent, false)
        return SalesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
       holder.onBind(imgList[position], position)
    }

    class SalesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ShapeableImageView = itemView.findViewById(R.id.imgView)
        fun onBind(model: ImgForBanner, int: Int) {
            imageView.setImageDrawable(model.imgDrawable)
        }
    }

}