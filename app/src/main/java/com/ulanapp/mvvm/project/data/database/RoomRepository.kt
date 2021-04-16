package com.ulanapp.mvvm.project.data.database

import com.ulanapp.mvvm.project.data.model.User
import io.reactivex.Observable
import javax.inject.Inject

class RoomRepository @Inject constructor(var usersDao: UsersDao) : Repository {

    override fun getAll(): Observable<List<User>> {
        return usersDao
            .getAll().toObservable()
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