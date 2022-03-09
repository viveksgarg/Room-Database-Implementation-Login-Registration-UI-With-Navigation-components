package com.example.roomdatabaseimplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized
import java.io.InputStream

@Database (entities = [UserEntity::class],version = 1)

abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDAO

    companion object {
        @Volatile
        private var INSTANCE : UserDatabase?= null

        fun getDatabase (context: Context) : UserDatabase{
            if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "usersDB"
                    )
                        .build()
                }
            return INSTANCE!!
        }
    }
}