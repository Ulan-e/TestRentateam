package com.ulanapp.testrentateam.data.ui.main

import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.ui.CallFragmentListener

class MainViewModel(listener: CallFragmentListener) : ViewModel() {

    var toolbarTitle = MutableLiveData<String>()
    private var fragmentCallListener: CallFragmentListener = listener

    init {
        toolbarTitle.value = "HomeFragment"
        this.fragmentCallListener.callFragment("HomeFragment")
    }

    fun NavigationClick(@NonNull menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.home -> {
                toolbarTitle.value = "HomeFragment"
                this.fragmentCallListener.callFragment("HomeFragment")
                true
            }
            R.id.info -> {
                toolbarTitle.value = "InfoFragment"
                this.fragmentCallListener.callFragment("InfoFragment")
                true
            }
            else -> false
        }
    }

}