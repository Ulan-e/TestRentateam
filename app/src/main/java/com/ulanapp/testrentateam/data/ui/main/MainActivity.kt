package com.ulanapp.testrentateam.data.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.ui.CallFragmentListener
import com.ulanapp.testrentateam.data.ui.home.HomeFragment
import com.ulanapp.testrentateam.data.ui.info.InfoFragment
import com.ulanapp.testrentateam.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CallFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        val activityBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityBinding.mainViewModel = mainViewModel

    }

    override fun callFragment(title: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, getFragmentByTitle(title))
            .addToBackStack(null)
            .commit()
    }

    private fun getFragmentByTitle(title: String): Fragment {
        return when (title) {
            "HomeFragment" -> HomeFragment()
            "InfoFragment" -> InfoFragment()
            else -> HomeFragment()
        }
    }
}