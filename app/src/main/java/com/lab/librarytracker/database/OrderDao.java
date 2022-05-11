package com.lab.librarytracker.database;

import com.lab.librarytracker.helper.DateConverter;
import com.lab.librarytracker.models.entities.Orders;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.TypeConverters;

@Dao
@TypeConverters(DateConverter.class)
public interface OrderDao {
    @Transaction
    @Query("SELECT * From orders")
    LiveData<List<Orders>> findAllOrders();

    @Insert()
    void insertOrders(Orders orders);

    @Transaction
    @Query("DELETE FROM orders")
    void deleteAll();
}
