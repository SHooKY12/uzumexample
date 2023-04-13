package com.example.exampleuzum

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.example.exampleuzum.databinding.RecyclerForRetrofirBinding
import dataclassesForUse.ListsForSaveSelectedAndLookedProducts
import dataclassesForUse.Product

class FullProductAdapter : RecyclerView.Adapter<FullProductAdapter.MainProductHolder>() {


    private var listProducts = mutableListOf<Product>()

    fun setImage(item: List<Product>) {
        listProducts.clear()
        listProducts.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainProductHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_for_retrofir, parent, false)
        return MainProductHolder(view)
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    override fun onBindViewHolder(holder: MainProductHolder, position: Int) {
        holder.onBind(listProducts[position], position)
    }

    class MainProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val saveClickedForWish = ListsForSaveSelectedAndLookedProducts()
        private var binding = RecyclerForRetrofirBinding.bind(itemView)
        fun onBind(model: Product, position: Int) {
            val rassrochkaForTextView = String.format("%.2f", model.price / 12)
            binding.oldPrice.text = model.price.toString()
            binding.oldPrice.paintFlags = binding.oldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            binding.ImageOfProduct.load(model.thumbnail) {
                scale(Scale.FILL)
                transformations(RoundedCornersTransformation(40f))
            }
            binding.newPrice.text = model.price.toString()
            binding.desriotionOfProduct.text = model.title
            binding.textRassrochka.text = String.format("%s сум/мес", rassrochkaForTextView)
            binding.textViewRaiting.text =
                String.format("%s (${model.stock} заказов)", model.rating.toString())
            binding.checkBoxInFrameWithImageView.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    if (!ListsForSaveSelectedAndLookedProducts.listForSAveCategories.contains(model)) {
                        ListsForSaveSelectedAndLookedProducts.addModel(model)
                    }
                        Toast.makeText(
                        itemView.context,
                        "Checked and senden ${model.title}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Toast.makeText(
                        itemView.context,
                        "What in List ${ListsForSaveSelectedAndLookedProducts.listForSAveCategories[0].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                   ListsForSaveSelectedAndLookedProducts.removeModel(model)
                    Toast.makeText(
                        itemView.context,
                        "Unchecked and deleted ${model.title}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Toast.makeText(
                        itemView.context,
                        "What in List Was Deleted ${
                            ListsForSaveSelectedAndLookedProducts.listForSAveCategories.getOrNull(1)
                        }",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}