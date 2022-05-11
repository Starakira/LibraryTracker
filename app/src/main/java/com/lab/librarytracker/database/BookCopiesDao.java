package com.lab.librarytracker.database;

import com.lab.librarytracker.models.relations.BooksWithCopies;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface BookCopiesDao {
    @Transaction
    @Query("SELECT * FROM books")
    LiveData<List<BooksWithCopies>> loadAllBooksWithCopies();
}
