package com.ulanapp.testrentateam.project.data.database

import android.util.Log
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.utils.TAG
import io.reactivex.Observable
import javax.inject.Inject

class RoomRepository @Inject constructor(var usersDao: UsersDao) : Repository {

    override fun getAll(): Observable<List<User>> {
        return usersDao
            .getAll().toObservable()
            .doOnNext {
                (Log.d(TAG, "Fetch data from database  " + it.toString()))
            }!!
    }

    override fun insertAll(users: List<User>) {
        for (item in users) {
            usersDao.insert(item)
        }
    }

    override fun removeAll() {
        usersDao.removeAll()
    }

}

interface Repository {

    fun getAll(): Observable<List<User>>

    fun insertAll(users: List<User>)

    fun removeAll()

}