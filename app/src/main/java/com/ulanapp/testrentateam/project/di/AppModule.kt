package com.ulanapp.testrentateam.project.di

import android.content.Context
import androidx.room.Room
import com.ulanapp.testrentateam.project.BaseApplication
import com.ulanapp.testrentateam.project.data.database.UserDatabase
import com.ulanapp.testrentateam.project.data.database.UsersDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun context(application: BaseApplication): Context

}