package com.ulanapp.mvvm.project.ui.main

import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import com.ulanapp.mvvm.R
import com.ulanapp.mvvm.project.listeners.CallFragmentListener
import com.ulanapp.mvvm.project.ui.main.MainActivity.Companion.HOME_FRAGMENT
import com.ulanapp.mvvm.project.ui.main.MainActivity.Companion.INFO_FRAGMENT

class MainViewModel(listener: CallFragmentListener) : ViewModel() {

    private var fragmentCallListener: CallFragmentListener = listener

    init {
        this.fragmentCallListener.callFragment(HOME_FRAGMENT)
    }

    fun NavigationClick(@NonNull menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.home -> {
                this.fragmentCallListener.callFragment(HOME_FRAGMENT)
                true
            }
            R.id.info -> {
                this.fragmentCallListener.callFragment(INFO_FRAGMENT)
                true
            }
            else -> false
        }
    }
}