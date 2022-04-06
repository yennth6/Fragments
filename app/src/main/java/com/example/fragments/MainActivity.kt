package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private var firstInt: Int? = 0
    var secondInt: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Log.d(TAG, "savedInstanceState null")
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ContainerFragment>(R.id.fullscreen_fragment_container, "ContainerFragment")
                addToBackStack(null)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_add -> {
                val fragment: ContainerFragment? = supportFragmentManager
                    .findFragmentByTag("ContainerFragment") as ContainerFragment?

                val sum = fragment?.getSum() ?: 0
                val bundle = bundleOf(
                    "sum" to sum
                )
                supportFragmentManager.commit {
                    replace<SumFragment>(R.id.fullscreen_fragment_container, "SumFragment", args = bundle)
                    addToBackStack(null)
                }

            }
        }

        return true
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

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed")
        super.onBackPressed()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("num", 0)
        super.onSaveInstanceState(outState)
    }
}