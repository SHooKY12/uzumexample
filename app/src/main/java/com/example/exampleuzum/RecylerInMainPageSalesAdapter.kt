package com.example.exampleuzum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dataclassesForUse.ImgForBanner

class RecylerInMainPageSalesAdapter :
    RecyclerView.Adapter<RecylerInMainPageSalesAdapter.SalesViewHolder>() {
    private var imgList = mutableListOf<ImgForBanner>()

    fun setImages(items: List<ImgForBanner>) {
        imgList.clear()
        imgList.addAll(items)
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
        TODO("Not yet implemented")
    }

    class SalesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

}