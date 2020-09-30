package com.ulanapp.testrentateam.project.data.network

import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.utils.TAG
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiRepository(private val reqresApi: ReqresApi) {

    fun retrieveAll(): Observable<List<User>> {
        return reqresApi.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .flatMap { response ->
                Log.d(TAG, "Fetch data from API " + response.data)
                Observable.just(response.data)
            }
    }

}