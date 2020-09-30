package com.ulanapp.testrentateam.project.di

import android.content.Context
import com.ulanapp.testrentateam.project.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @MainScope
    @Binds
    abstract fun context(application: BaseApplication): Context

}