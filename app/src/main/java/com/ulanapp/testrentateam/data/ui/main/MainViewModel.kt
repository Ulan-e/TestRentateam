package com.ulanapp.testrentateam.data.ui.main

import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.listeners.CallFragmentListener

class MainViewModel(listener: CallFragmentListener) : ViewModel() {

    private var fragmentCallListener: CallFragmentListener = listener

    init {
        this.fragmentCallListener.callFragment("HomeFragment")
    }

    fun NavigationClick(@NonNull menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.home -> {
                this.fragmentCallListener.callFragment("HomeFragment")
                true
            }
            R.id.info -> {
                this.fragmentCallListener.callFragment("InfoFragment")
                true
            }
            else -> false
        }
    }

}