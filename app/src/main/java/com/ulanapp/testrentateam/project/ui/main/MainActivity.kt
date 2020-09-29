package com.ulanapp.testrentateam.project.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.databinding.ActivityMainBinding
import com.ulanapp.testrentateam.project.listeners.CallFragmentListener
import com.ulanapp.testrentateam.project.ui.home.HomeFragment
import com.ulanapp.testrentateam.project.ui.info.InfoFragment
import com.ulanapp.testrentateam.project.utils.isNetworkAvailable
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity(),
    CallFragmentListener {

    val HOME_FRAGMENT = "HomeFragment"
    val INFO_FRAGMENT = "InfoFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        checkInternetConnection()

        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val activityBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityBinding.mainViewModel = mainViewModel
        setSupportActionBar(main_toolbar)

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

    fun checkInternetConnection() {
        if (!isNetworkAvailable(this)) {
            Toast.makeText(this, "Нет подключения к Интернету", Toast.LENGTH_SHORT).show()
        }
    }

}