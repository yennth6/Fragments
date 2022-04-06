package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments.view_models.FirstNumViewModel
import com.example.fragments.view_models.SecondNumViewModel

class AlterNumFragment: Fragment(), View.OnClickListener {
    var num = 0
    private val TAG = "AlterNumFragment"
    private var textNum: TextView? = null
    private var buttonAdd: Button? = null
    private var buttonMinus: Button? = null
    private var buttonDetail: Button? = null
    var fragmentId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        fragmentId = this.id
        return inflater.inflate(R.layout.fragment_alter_num, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        textNum = getView()?.findViewById(R.id.textview_number) as TextView
        buttonAdd = getView()?.findViewById(R.id.button_add) as Button
        buttonMinus = getView()?.findViewById(R.id.button_minus) as Button
        buttonDetail = getView()?.findViewById(R.id.button_view_detail) as Button


        buttonAdd?.setOnClickListener(this)
        buttonMinus?.setOnClickListener(this)
        buttonDetail?.setOnClickListener(this)

        if (savedInstanceState != null) {
            num = savedInstanceState.getInt("num")
        }
        textNum?.text = num.toString()

    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.button_add -> {
                num += 1
                textNum?.text = num.toString()
            }

            R.id.button_minus -> {
                num -= 1
                textNum?.text = num.toString()
            }

            R.id.button_view_detail -> {
                val bundle = bundleOf(
                    "num" to num
                )
                parentFragmentManager.commit {
                    replace<DetailFragment>(fragmentId, args = bundle)
                    addToBackStack(null)
                }
            }
        }
    }

    fun getNumber(): Int {
        return num
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("num", num)
        Log.d(TAG, "saveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}