package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import com.example.fragments.view_models.FirstNumViewModel
import com.example.fragments.view_models.SecondNumViewModel

class SumFragment: Fragment() {
    var fragmentId = 0
    private var toolbar: Toolbar? = null
    private var textView: TextView? = null
    var sum  = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentId = this.id
        return inflater.inflate(R.layout.fragment_sum, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sum = arguments?.getInt("sum")!!
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = getView()?.findViewById(R.id.toolbar_sum_fragment) as Toolbar
        textView = getView()?.findViewById(R.id.text_view_sum) as TextView
        toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        textView?.text = sum.toString()
        toolbar?.setNavigationOnClickListener {

//            parentFragmentManager.commit {
//                replace<ContainerFragment>(fragmentId)
//            }
            activity?.supportFragmentManager?.popBackStackImmediate()
        }
    }
}