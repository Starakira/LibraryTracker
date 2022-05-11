package com.lab.librarytracker.database;

import com.lab.librarytracker.models.relations.CopiesWithOrders;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface CopyOrdersDao {
    @Transaction
    @Query("SELECT * FROM copies")
    LiveData<List<CopiesWithOrders>> loadAllCopiesWithOrders();
}
