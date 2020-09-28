package com.ulanapp.testrentateam.data.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.data.DataRepository
import com.ulanapp.testrentateam.data.database.UserRepository
import com.ulanapp.testrentateam.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    val data = MutableLiveData<List<User>>()
    private lateinit var repo: DataRepository

    fun setRepo(repository: DataRepository) {
        this.repo = repository
    }


    fun doSomething() {
        repo.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res ->
                    data.value = res
                    Log.d("ulanbek", "From MainActivity " + res)},
                {err -> Log.d("ulanbek", "Error" + err.message)})
    }

}