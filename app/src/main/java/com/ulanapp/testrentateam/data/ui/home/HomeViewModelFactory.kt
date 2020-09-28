package com.ulanapp.testrentateam.data.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.testrentateam.data.data.DataRepository

class HomeViewModelFactory(private var repository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}