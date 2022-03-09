package com.example.roomdatabaseimplementation

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser (userEntity: UserEntity)

    @Delete
    suspend fun deleteUser (userEntity: UserEntity)

    @Query("SELECT * FROM userTable")
    fun getAllUsers() : LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserTable WHERE email =:email AND password =:password")
    fun readAllData(email: String?, password: String?): LiveData<UserEntity>

}