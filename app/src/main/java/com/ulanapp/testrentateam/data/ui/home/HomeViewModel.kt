package com.ulanapp.testrentateam.data.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.data.data.DataRepository
import com.ulanapp.testrentateam.data.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(var repository: DataRepository) : ViewModel() {

    val progress = MutableLiveData<Boolean>()
    val data = MutableLiveData<List<User>>()

    init {
        progress.value = true
        loadData()
    }

    private fun loadData() {
        repository.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnNext({progress.value = false})
            .subscribe(
                {res ->
                    data.value = res
                    Log.d("rentateam", "From MainActivity " + res)},
                {err -> Log.d("rentateam", "Error" + err.message)})
    }

}