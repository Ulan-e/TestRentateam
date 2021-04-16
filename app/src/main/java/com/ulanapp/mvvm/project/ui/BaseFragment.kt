package com.ulanapp.mvvm.project.ui

import android.content.Context
import android.os.Bundle
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

open class BaseFragment: DaggerFragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
}