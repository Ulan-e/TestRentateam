package com.ulanapp.testrentateam.project.data.database

import android.content.Context
import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository @Inject constructor(var usersDao: UsersDao) {

    fun getAll(): Observable<List<User>> {
        return usersDao
            .getAll().toObservable()
            ?.doOnNext{(Log.d("ulanbek", "From DB  " + it.toString()))
            }!!
    }

    fun insert(list: List<User>) {
        for (i in list) {
            usersDao.insert(i)
        }
    }

    fun removeAll(){
        usersDao.removeAll()
    }

}