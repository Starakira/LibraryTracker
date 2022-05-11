package com.lab.librarytracker.database;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;

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
public interface CopyDao {
    @Transaction
    @Query("select * from copies where id = :id")
    Books loadCopyById(int id);

    @Transaction
    @Query("SELECT * FROM copies")
    LiveData<List<Copies>> findAllCopies();

    @Transaction
    @Query("SELECT * FROM copies")
    List<Copies> findAllCopiesSync();

    @Insert(onConflict = IGNORE)
    void insertCopy(Copies copies);

    @Transaction
    @Query("DELETE FROM copies")
    void deleteAll();
}
