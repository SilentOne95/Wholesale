package com.bobbiny.wholesale.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.User;

import java.util.List;

/**
 * Data Access Object for the other table.
 */
@Dao
public interface UserDao {

    /**
     * Select all users from the user table.
     *
     * @return all users.
     */
    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();

    /**
     * Insert all users to the user table.
     */
    @Insert
    void insertAllUsers(List<User> userList);
}
