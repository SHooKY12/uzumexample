package fragmentsPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleuzum.FullProductAdapter
import com.example.exampleuzum.R
import com.example.exampleuzum.RetrofitApi
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FrangmentPopularInMainPage : Fragment(R.layout.fragment_frangment_popular_in_main_page) {
    lateinit var recycler_view:RecyclerView
   val adapter = FullProductAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view = view.findViewById(R.id.recycler_view_in_frgpopular)
        // Инициализая retrofit и подключения к нему Интерфейсаа
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val mainApi = retrofit.create(RetrofitApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
          val list = mainApi.getAllProducts()
           activity?.runOnUiThread{
               adapter.setImage(list.products)
               val layoutManager = GridLayoutManager(view.context, 2, GridLayoutManager.VERTICAL, false)
               recycler_view.layoutManager = layoutManager
               recycler_view.adapter = adapter
           }
        }
    }

    companion object {
        fun newInstance(): FrangmentPopularInMainPage {
            return FrangmentPopularInMainPage()
        }
    }


}