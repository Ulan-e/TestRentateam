package com.ulanapp.testrentateam.project.data.network

import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiRepository {

    fun getFromApi(): Observable<List<User>> {
        val networkService = NetworkService.create()
        return networkService.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .flatMap { res ->
                Log.d("ulanbek", "From API " + res.data)
                Observable.just(res.data)
            }
    }

}