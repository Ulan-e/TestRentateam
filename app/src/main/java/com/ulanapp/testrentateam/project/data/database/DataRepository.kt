package com.ulanapp.testrentateam.project.data.database

import android.content.Context
import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository  {

    var usersDao: UsersDao

    @Inject
    constructor(usersDao: UsersDao){
        this.usersDao = usersDao
    }

    fun getFromDb(): Observable<List<User>> {
        return usersDao
            ?.getAll()?.toObservable()
            ?.doOnNext{(Log.d("ulanbek", "From DB  " + it.toString()))
            }!!
    }

    fun insertToDb(list: List<User>) {
        for (i in list) {
           usersDao?.insert(i)
        }
    }

    fun clearDb(){
        usersDao?.removeAll()
    }

}