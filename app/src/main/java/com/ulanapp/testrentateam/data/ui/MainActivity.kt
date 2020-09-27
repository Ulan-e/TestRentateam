package com.ulanapp.testrentateam.data.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rep = DataRepository(this)
        rep.fetchUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {data -> Log.d("ulanbek", "From MainActivity " + data)},
                {err -> Log.d("ulanbek", "Error" + err.message)})

    }
}