package com.lab.librarytracker.database;

import com.lab.librarytracker.models.relations.UsersWithOrders;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface UserOrdersDao {
    @Transaction
    @Query("SELECT * FROM users")
    LiveData<List<UsersWithOrders>> loadAllUsersWithOrders();
}
