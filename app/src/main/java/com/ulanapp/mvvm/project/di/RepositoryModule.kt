package com.ulanapp.mvvm.project.di

import androidx.room.Room
import com.ulanapp.mvvm.project.BaseApplication
import com.ulanapp.mvvm.project.data.UsersRepository
import com.ulanapp.mvvm.project.data.database.Repository
import com.ulanapp.mvvm.project.data.database.RoomRepository
import com.ulanapp.mvvm.project.data.database.UserDatabase
import com.ulanapp.mvvm.project.data.network.ApiRepository
import com.ulanapp.mvvm.project.data.network.NetworkService
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
    fun provideDatabaseRepository(database: UserDatabase): Repository {
        return RoomRepository(database.usersDao())
    }

    @Provides
    fun provideUsersApi(): ApiRepository {
        return ApiRepository(NetworkService.create())
    }

    @Provides
    fun provideUsersRepository(database: Repository, api: ApiRepository): UsersRepository {
        return UsersRepository(database, api)
    }
}