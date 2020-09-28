package com.ulanapp.testrentateam.data.data

import android.content.Context
import com.ulanapp.testrentateam.data.data.database.UserRepository
import com.ulanapp.testrentateam.data.data.model.User
import com.ulanapp.testrentateam.data.data.network.ApiRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DataRepository(private  val context: Context){

    val dbRepo = UserRepository(context)
    val apiRepo = ApiRepository()

    fun fetchUsers(): Observable<List<User>> {
        val dbObservable = dbRepo.getFromDb()
            .subscribeOn(Schedulers.io())
        val apiObservable = apiRepo.getFromApi().doOnNext {
            dbRepo.clearDb()
            dbRepo.insertToDb(it)
        }
        return Observable.mergeDelayError(apiObservable, dbObservable)
    }

}