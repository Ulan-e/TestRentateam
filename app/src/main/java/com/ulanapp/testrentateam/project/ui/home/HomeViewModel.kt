package com.ulanapp.testrentateam.project.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.project.data.DataRepository
import com.ulanapp.testrentateam.project.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private var repository: DataRepository) : ViewModel() {

    val loadingProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val data = MutableLiveData<List<User>>()

    init {
        loadingProgress.value = true
        loadData()
    }

    private fun loadData() {
        repository.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnNext({ loadingProgress.value = false })
            .subscribe(
                { result ->
                    data.value = result
                    Log.d(
                        "rentateamproject",
                        "HomeViewModel -> Success loading from Data repository" + result
                    )
                },
                { error ->
                    errorMessage.value = error.message
                    Log.d(
                        "rentateamproject",
                        "HomeViewModel -> Error loading from DataRepository" + error.message
                    )
                })
    }

}