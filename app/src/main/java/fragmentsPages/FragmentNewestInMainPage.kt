package fragmentsPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exampleuzum.R

class FragmentNewestInMainPage : Fragment(R.layout.fragment_newest_in_main_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        fun newInstance(): FragmentNewestInMainPage {
        return FragmentNewestInMainPage()
        }
    }
}