package com.lab.librarytracker.models.entities;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "bookId")
})
public class Copies implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @ColumnInfo(name = "bookId")
    private int bookId = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
