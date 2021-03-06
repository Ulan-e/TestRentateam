package com.ulanapp.mvvm.project.data.database

import androidx.room.*
import com.ulanapp.mvvm.project.data.model.User
import io.reactivex.Flowable

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao
}

@Dao
interface UsersDao {

    @Query("SELECT * FROM cachedUsers")
    fun getAll(): Flowable<List<User>>

    @Query("DELETE FROM cachedUsers")
    fun removeAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long
}