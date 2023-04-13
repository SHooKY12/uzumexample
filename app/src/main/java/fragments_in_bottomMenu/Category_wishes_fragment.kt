package fragments_in_bottomMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleuzum.R
import dataclassesForUse.ListsForSaveSelectedAndLookedProducts


class Category_wishes_fragment : Fragment(R.layout.fragment_category_wishes_fragment) {
    lateinit var recyclerView: RecyclerView
    private val adapter = Ifwishhave_Adapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recycler_view_in_have_wishes)
        adapter.setProducts(ListsForSaveSelectedAndLookedProducts.listForSAveCategories)
        val layoutManager = GridLayoutManager(view.context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = Category_wishes_fragment()
    }
}