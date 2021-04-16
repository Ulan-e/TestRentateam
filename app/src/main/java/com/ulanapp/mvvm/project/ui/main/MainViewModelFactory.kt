package com.ulanapp.mvvm.project.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.mvvm.project.listeners.CallFragmentListener

class MainViewModelFactory(private var listener: CallFragmentListener) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(listener) as T
    }
}