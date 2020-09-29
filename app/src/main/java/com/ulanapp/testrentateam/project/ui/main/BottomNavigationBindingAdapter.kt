package com.ulanapp.testrentateam.project.ui.main

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ulanapp.testrentateam.R

class BottomNavigationBindingAdapter {

    companion object{
        @BindingAdapter("onItemSelected")
        @JvmStatic
        fun setNavigationClickListener(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener){
            view.selectedItemId = R.id.home
            view.setOnNavigationItemSelectedListener(listener)
        }
    }
}