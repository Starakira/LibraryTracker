package com.lab.librarytracker.database;

import com.lab.librarytracker.models.entities.Users;
import com.lab.librarytracker.models.relations.UsersWithOrders;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Transaction
    @Insert(onConflict = REPLACE)
    void insertUser(Users users);

    @Transaction
    @Query("SELECT * FROM users")
    LiveData<List<Users>> loadAllUsers();

    @Transaction
    @Query("SELECT * FROM users WHERE id = :id")
    Users loadUserById(int id);

    @Delete
    void deleteUser(Users users);

    @Insert(onConflict = REPLACE)
    void insertOrReplaceUsers(Users... users);

    @Delete
    void deleteUsers(Users user1, Users user2);

    @Transaction
    @Query("DELETE FROM users")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM users")
    LiveData<List<UsersWithOrders>> loadAllUsersWithOrders();
}
