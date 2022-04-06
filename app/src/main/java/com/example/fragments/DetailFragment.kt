package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class DetailFragment: Fragment() {
    var num = 0
    private var textNum: TextView? = null
    private var toolbar: Toolbar? = null
    private var fragmentId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        num = arguments?.getInt("num")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentId = this.id
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textNum = getView()?.findViewById(R.id.text_view_detail) as TextView
        toolbar = getView()?.findViewById(R.id.toolbar) as Toolbar

        toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar?.setNavigationOnClickListener {
            Log.d("DetailFragment", "click ")
            val bundle = bundleOf(
                "num" to num
            )
            parentFragmentManager.popBackStackImmediate(R.id.fragment_first, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        textNum?.text = num.toString()
    }

}