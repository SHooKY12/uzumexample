package fragments_in_bottomMenu

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.example.exampleuzum.R
import com.example.exampleuzum.databinding.FragmentIfwishhaveProductBinding
import dataclassesForUse.ListsForSaveSelectedAndLookedProducts
import dataclassesForUse.Product


class Ifwishhave_Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_VIEW_HAVE_WISH = 0
        const val TYPE_VIEW_HAVE_NOT_WISH = 1
    }

    private var products = mutableListOf<Product>()
    fun setProducts(items: List<Product>) {
        products.clear()
        products.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (products.size) {
            0 -> TYPE_VIEW_HAVE_NOT_WISH
            else -> TYPE_VIEW_HAVE_WISH
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_VIEW_HAVE_WISH -> {
                val viewForWish = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_ifwishhave_product, parent, false)
                return Wish_Have_Product_ViewHolder(viewForWish)
            }
            TYPE_VIEW_HAVE_NOT_WISH -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_if_wish_have_not_product, parent, false)
                return Wish_Have_Not_Product_ViewHolder(view)
            }
            else -> throw IllegalAccessException("Holder Not Found")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {

            0 -> {
                val wish_Have_Product_ViewHolder = holder as Wish_Have_Product_ViewHolder
                wish_Have_Product_ViewHolder.onBind(products[position])
            }
            else -> {
                val wish_Have_Not_Product_ViewHolder = holder as Wish_Have_Not_Product_ViewHolder
                wish_Have_Not_Product_ViewHolder.onBind(products[position], products[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return products.size
    }


    inner class Wish_Have_Product_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = FragmentIfwishhaveProductBinding.bind(itemView)
        fun onBind(model: Product) {
            val newPrice = model.price / 1.12
            binding.ImageOfProductInWishFrag.load(model.thumbnail) {
                scale(Scale.FILL)
                transformations(RoundedCornersTransformation(40f))
            }
            binding.checkBoxInFrameWithImageViewnInWishFrag.setOnCheckedChangeListener { buttonView, isChecked ->
                if (!isChecked) {
                    ListsForSaveSelectedAndLookedProducts.removeModel(model)
                    setProducts(ListsForSaveSelectedAndLookedProducts.listForSAveCategories)
                }
            }

            binding.desriotionOfProductInWishFrag.text = model.title
            binding.oldPriceInWishFrag.text = model.price.toString()
            binding.oldPriceInWishFrag.paintFlags =
                binding.oldPriceInWishFrag.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            binding.newPriceInWishFrag.text = newPrice.toString()
            binding.textViewRaitingInWishFrag.text =
                String.format("%s (${model.stock} заказов)", model.rating.toString())
        }
    }

    inner class Wish_Have_Not_Product_ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(modelPopular: Product, modelLastClientSee: Product) {
        }
    }

}


























































