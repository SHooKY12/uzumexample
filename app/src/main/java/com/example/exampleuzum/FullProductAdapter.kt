package com.example.exampleuzum

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.example.exampleuzum.databinding.RecyclerForRetrofirBinding
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
        val images = mutableListOf<String>(
            "https://drive.google.com/file/d/1AVqV2YZMIuQHZmiwlZb1l38Vdh9CGBKT/view?usp=share_link",
            "https://drive.google.com/file/d/1fKGciRpy8f4iJDhlaAjXP_PYVtDrPoP3/view?usp=share_link",
            "https://drive.google.com/file/d/1ox804kufiAkmTamMoAJLH7qJlTzLMUpS/view?usp=share_link",
            "https://drive.google.com/file/d/1W0bgLDW2tVP4Y_8peTMmPdtfiR99Zqw0/view?usp=share_link",
            "https://drive.google.com/file/d/1AVqV2YZMIuQHZmiwlZb1l38Vdh9CGBKT/view?usp=share_link",
            "https://drive.google.com/file/d/13TEPPK--vErzTYnLHCLol09WwG7cMNcD/view?usp=share_link",
            "https://drive.google.com/file/d/1cpzLYY9ciUaa7NC91qDZ-wsmBOUUQXaS/view?usp=share_link",
            "https://drive.google.com/file/d/109Zd0v2lG3SyK3B5p8c8lddSFa6jbl56/view?usp=share_link",
            "https://drive.google.com/file/d/1UANCykk3u7DxpXbtRDrxLdO2XodrDNsy/view?usp=share_link",
            "https://drive.google.com/file/d/1tpa8fvTgxt6yZbFiPIH0cTdVJh3YNryU/view?usp=share_link",
            "https://drive.google.com/file/d/1sboBwcGkOt-bZiFZNw5QV8iY6_8_ldhG/view?usp=share_link",
            "https://drive.google.com/file/d/1ox804kufiAkmTamMoAJLH7qJlTzLMUpS/view?usp=share_link",
            "https://drive.google.com/file/d/1W0bgLDW2tVP4Y_8peTMmPdtfiR99Zqw0/view?usp=share_link",
            "https://drive.google.com/file/d/13TEPPK--vErzTYnLHCLol09WwG7cMNcD/view?usp=share_link",
            "https://drive.google.com/file/d/1cpzLYY9ciUaa7NC91qDZ-wsmBOUUQXaS/view?usp=share_link",
            "https://drive.google.com/file/d/109Zd0v2lG3SyK3B5p8c8lddSFa6jbl56/view?usp=share_link",
            "https://drive.google.com/file/d/1UANCykk3u7DxpXbtRDrxLdO2XodrDNsy/view?usp=share_link",
            "https://drive.google.com/file/d/1tpa8fvTgxt6yZbFiPIH0cTdVJh3YNryU/view?usp=share_link",
            "https://drive.google.com/file/d/1sboBwcGkOt-bZiFZNw5QV8iY6_8_ldhG/view?usp=share_link",
            "https://drive.google.com/file/d/1ox804kufiAkmTamMoAJLH7qJlTzLMUpS/view?usp=share_link",
            "https://drive.google.com/file/d/1W0bgLDW2tVP4Y_8peTMmPdtfiR99Zqw0/view?usp=share_link",
            "https://drive.google.com/file/d/13TEPPK--vErzTYnLHCLol09WwG7cMNcD/view?usp=share_link",
            "https://drive.google.com/file/d/1cpzLYY9ciUaa7NC91qDZ-wsmBOUUQXaS/view?usp=share_link",
            "https://drive.google.com/file/d/109Zd0v2lG3SyK3B5p8c8lddSFa6jbl56/view?usp=share_link",
            "https://drive.google.com/file/d/1UANCykk3u7DxpXbtRDrxLdO2XodrDNsy/view?usp=share_link",
            "https://drive.google.com/file/d/1tpa8fvTgxt6yZbFiPIH0cTdVJh3YNryU/view?usp=share_link",
            "https://drive.google.com/file/d/1sboBwcGkOt-bZiFZNw5QV8iY6_8_ldhG/view?usp=share_link",
            "https://drive.google.com/file/d/1ox804kufiAkmTamMoAJLH7qJlTzLMUpS/view?usp=share_link",
            "https://drive.google.com/file/d/1W0bgLDW2tVP4Y_8peTMmPdtfiR99Zqw0/view?usp=share_link",
            "https://drive.google.com/file/d/1W0bgLDW2tVP4Y_8peTMmPdtfiR99Zqw0/view?usp=share_link"
        )
        private val binding = RecyclerForRetrofirBinding.bind(itemView)
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
                String.format("%s (15000 заказов)", model.rating.toString())
        }
    }

}