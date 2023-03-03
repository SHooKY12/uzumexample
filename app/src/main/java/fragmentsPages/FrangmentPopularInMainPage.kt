package fragmentsPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.doOnPreDraw
import com.example.exampleuzum.R
import com.google.android.material.tabs.TabLayout

class FrangmentPopularInMainPage : Fragment(R.layout.fragment_frangment_popular_in_main_page) {
    private var height = 0;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = view.viewTreeObserver
//        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.tableLayoutInMainPage)
//         view.doOnPreDraw { tabLayout.layoutParams.height = view.height }
        //        observer.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener{
//        override fun onGlobalLayout() {
//            height = view.height
//            tabLayout?.layoutParams?.height = height
//            observer?.removeOnGlobalLayoutListener(this)
//        }
//    })
    }

    companion object {
        fun newInstance(): FrangmentPopularInMainPage {
            return FrangmentPopularInMainPage()
        }
    }

    fun getHeight(): Int {
        return height
    }
}