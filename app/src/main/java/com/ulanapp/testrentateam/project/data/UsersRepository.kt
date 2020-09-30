package com.ulanapp.testrentateam.project.data

import com.ulanapp.testrentateam.project.data.database.Repository
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.data.network.ApiRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val dbRepository: Repository,
    private val apiRepository: ApiRepository
) {

    // returns Observable result of merging two Observables if one of them terminates without onError()
    fun mergeResult(): Observable<List<User>> {
        val dbObservable = dbRepository.getAll()
            .subscribeOn(Schedulers.io())
        val apiObservable = apiRepository.retrieveAll().doOnNext {
            dbRepository.removeAll()
            dbRepository.insertAll(it)
        }
        return Observable.mergeDelayError(apiObservable, dbObservable)
    }

}