package com.ulanapp.testrentateam.project.data.database

import android.content.Context
import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import io.reactivex.Observable

class UserRepository(private val context: Context)  {

    val db = UserDatabase.getAppDataBase(context)

    fun getFromDb(): Observable<List<User>> {
        return db
            ?.usersDao()
            ?.getAll()?.toObservable()
            ?.doOnNext{(Log.d("ulanbek", "From DB  " + it.toString()))
            }!!
    }

    fun insertToDb(list: List<User>) {
        for (i in list) {
            db?.usersDao()?.insert(i)
        }
    }

    fun clearDb(){
        db?.usersDao()?.removeAll()
    }

}