package com.ulanapp.testrentateam.data.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.listeners.CallFragmentListener
import com.ulanapp.testrentateam.data.ui.home.HomeFragment
import com.ulanapp.testrentateam.data.ui.info.InfoFragment
import com.ulanapp.testrentateam.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    CallFragmentListener {

    val HOME_FRAGMENT = "HomeFragment"
    val INFO_FRAGMENT = "InfoFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val activityBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityBinding.mainViewModel = mainViewModel
        setSupportActionBar(main_toolbar)
        mainViewModel.toolbarTitle.observe(this,
            Observer {
                if (it == HOME_FRAGMENT)
                    supportActionBar?.title = "Главная"
                else
                    supportActionBar?.title = "Инфо"
            })

    }

    override fun callFragment(title: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, getFragmentByTitle(title))
            .addToBackStack(null)
            .commit()
    }

    private fun getFragmentByTitle(title: String): Fragment {
        return when (title) {
            HOME_FRAGMENT -> HomeFragment()
            INFO_FRAGMENT -> InfoFragment()
            else -> HomeFragment()
        }
    }

}