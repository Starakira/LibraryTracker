package com.lab.librarytracker.database;

import com.lab.librarytracker.helper.DateConverter;
import com.lab.librarytracker.models.entities.Books;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface BookDao {
    @Transaction
    @Query("select * from books where id = :id")
    Books loadBookById(int id);

    @Transaction
    @Query("SELECT * FROM books")
    LiveData<List<Books>> findAllBooks();

    @Transaction
    @Query("SELECT * FROM books")
    List<Books> findAllBooksSync();

    @Insert(onConflict = IGNORE)
    void insertBook(Books books);

    @Update(onConflict = REPLACE)
    void updateBook(Books books);

    @Transaction
    @Query("DELETE FROM books")
    void deleteAll();
}
