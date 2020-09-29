package com.ulanapp.testrentateam.project.data

import com.ulanapp.testrentateam.project.data.database.DataRepository
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.data.network.ApiRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val dbRepository: DataRepository,
    private val apiRepository: ApiRepository
) {

    fun mergedResult(): Observable<List<User>> {
        val dbObservable = dbRepository.getAll()
            .subscribeOn(Schedulers.io())
        val apiObservable = apiRepository.retrieveAll().doOnNext {
            dbRepository.removeAll()
            dbRepository.insert(it)
        }
        return Observable.mergeDelayError(apiObservable, dbObservable)
    }

}