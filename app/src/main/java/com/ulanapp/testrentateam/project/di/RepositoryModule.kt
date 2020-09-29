package com.ulanapp.testrentateam.project.di

import androidx.room.Room
import com.ulanapp.testrentateam.project.BaseApplication
import com.ulanapp.testrentateam.project.data.UsersRepository
import com.ulanapp.testrentateam.project.data.database.DataRepository
import com.ulanapp.testrentateam.project.data.database.UserDatabase
import com.ulanapp.testrentateam.project.data.network.ApiRepository
import com.ulanapp.testrentateam.project.data.network.NetworkService
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(AppModule::class))
class RepositoryModule {

    @Provides
    fun provideDatabase(app: BaseApplication): UserDatabase = Room
        .databaseBuilder(app, UserDatabase::class.java, "users_db")
        .allowMainThreadQueries()
        .build()

    @Provides
    fun provideUsersDao(database: UserDatabase): DataRepository {
        return DataRepository(database.usersDao())
    }

    @Provides
    fun provideUsersApi(): ApiRepository {
        return ApiRepository(NetworkService.create())
    }

    @Provides
    fun provideUsersRepository(database: DataRepository, api: ApiRepository): UsersRepository {
        return UsersRepository(database, api)
    }

}