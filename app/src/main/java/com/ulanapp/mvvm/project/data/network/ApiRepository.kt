package com.ulanapp.mvvm.project.data.network

import com.ulanapp.mvvm.project.data.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiRepository
    (
    private val reqresApi: ReqresApi
) {

    fun retrieveAll(): Observable<List<User>> {
        return reqresApi.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .flatMap { response ->
                Observable.just(response.data)
            }
    }
}