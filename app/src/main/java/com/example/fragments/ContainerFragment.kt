package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class ContainerFragment: Fragment() {
    val TAG = "ContainerFragment"

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

        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstFragment: AlterNumFragment? = childFragmentManager
            .findFragmentByTag("FirstFragment") as AlterNumFragment?
        val secondFragment: AlterNumFragment? = childFragmentManager
            .findFragmentByTag("SecondFragment") as AlterNumFragment?
        if (firstFragment == null && secondFragment == null) {
            childFragmentManager.commit {
                replace<AlterNumFragment>(R.id.fragment_first, "FirstFragment")
                addToBackStack(null)

            }
            childFragmentManager.commit {
                replace<AlterNumFragment>(R.id.fragment_second, "SecondFragment")
                addToBackStack(null)
            }
        }
    }
    fun getSum() : Int {
        var sum = 0
        val firstFragment: AlterNumFragment? = childFragmentManager
                            .findFragmentByTag("FirstFragment") as AlterNumFragment?
        val secondFragment: AlterNumFragment? = childFragmentManager
                            .findFragmentByTag("SecondFragment") as AlterNumFragment?
        if (firstFragment != null && secondFragment != null) {
            sum = firstFragment.getNumber() + secondFragment.getNumber()
            Log.d(TAG, "firstFragment num: ${firstFragment.getNumber()}")
            Log.d(TAG, "secondFragment num: ${secondFragment.getNumber()}")
        } else {
            Log.d(TAG, "null")
        }
        return  sum
    }
}