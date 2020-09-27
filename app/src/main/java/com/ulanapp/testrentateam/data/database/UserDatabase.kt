package com.ulanapp.testrentateam.data.database

import android.content.Context
import androidx.room.*
import com.ulanapp.testrentateam.data.model.User
import io.reactivex.Flowable

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object {
        private var instance: UserDatabase? = null

        fun getAppDataBase(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "myDB"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }

    }

}

@Dao
interface UsersDao {

    @Query("SELECT * FROM cachedUsers")
    fun getAll(): Flowable<List<User>>

    @Query("DELETE FROM cachedUsers")
    fun removeAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User):Long

}
