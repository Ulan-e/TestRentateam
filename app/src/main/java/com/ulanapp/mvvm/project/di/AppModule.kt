package com.ulanapp.mvvm.project.di

import android.content.Context
import com.ulanapp.mvvm.project.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @MainScope
    @Binds
    abstract fun context(application: BaseApplication): Context
}