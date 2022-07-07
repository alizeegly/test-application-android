package com.alizee.applicationtest.repository

import android.content.Context
import com.alizee.applicationtest.DAO.UserDao
import com.alizee.applicationtest.db.AppDatabase
import com.alizee.applicationtest.models.User

class UserRepository (context: Context) {

    var db: UserDao = AppDatabase.getInstance(context)?.userDao()!!


    //Fetch All the Users
    fun getAllUsers(): List<User> {
        return db.gelAllUsers()
    }

    // Insert new user
    fun insertUser(user: User) {
        db.insertUser(user)

    }
    // Insert All users
    fun insertAllUserS(users: MutableList<User>) {
        for(user in users)
            db.insertUser(user)

    }

    // update user
    fun updateUser(users: User) {

        db.updateUser(users)
    }

    // Delete user
    fun deleteUser(users: User) {
        db.deleteUser(users)
    }

}