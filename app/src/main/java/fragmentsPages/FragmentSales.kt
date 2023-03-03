package fragmentsPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.exampleuzum.R


class FragmentSales : Fragment(R.layout.fragment_sales) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        val textView = view.findViewById<TextView>(R.id.salesTextView)

    }

    companion object {
        fun newInstance(): FragmentSales {
            return  FragmentSales()
        }

    }
}