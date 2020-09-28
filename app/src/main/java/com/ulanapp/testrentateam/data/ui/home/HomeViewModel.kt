package com.ulanapp.testrentateam.data.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.data.data.DataRepository
import com.ulanapp.testrentateam.data.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(var repository: DataRepository) : ViewModel() {

    val data = MutableLiveData<List<User>>()

    init {
        doSomething()
    }

    private fun doSomething() {
        repository.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res ->
                    data.value = res
                    Log.d("ulanbek", "From MainActivity " + res)},
                {err -> Log.d("ulanbek", "Error" + err.message)})
    }

}