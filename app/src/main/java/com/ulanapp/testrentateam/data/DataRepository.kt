package com.ulanapp.testrentateam.data

import android.content.Context
import com.ulanapp.testrentateam.data.database.UserRepository
import com.ulanapp.testrentateam.data.models.User
import com.ulanapp.testrentateam.data.network.ApiRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DataRepository(private  val context: Context){

    val dbRepo = UserRepository(context)
    val apiRepo = ApiRepository()

    fun fetchUsers(): Observable<List<User>> {
        val dbObservable = dbRepo.getFromDb().subscribeOn(Schedulers.io())
        val apiObservvable = apiRepo.getFromApi().doOnNext {
            dbRepo.clearDb()
            dbRepo.insertToDb(it)
        }
        return Observable.mergeDelayError(apiObservvable, dbObservable)
    }

}