package com.ulanapp.testrentateam.project.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulanapp.testrentateam.project.data.UsersRepository
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.utils.TAG
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private var repository: UsersRepository) : ViewModel() {

    val loadingProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val data = MutableLiveData<List<User>>()

    private var disposable: CompositeDisposable = CompositeDisposable()

    init {
        loadingProgress.value = true
        loadData()
    }

    private fun loadData() {
        disposable.add(
            repository.mergeResult()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext({ loadingProgress.value = false })
                .subscribe(
                    { result ->
                        data.value = result
                        Log.d(
                            TAG,
                            "HomeViewModel -> Success loading from Data repository" + result
                        )
                    },
                    { error ->
                        errorMessage.value = error.message
                        Log.d(
                            TAG,
                            "HomeViewModel -> Error loading from DataRepository" + error.message
                        )
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}