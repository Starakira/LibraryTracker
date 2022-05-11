package com.lab.librarytracker.models.entities;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Books implements Serializable {

    @PrimaryKey(autoGenerate = true)
        private int id = 0;

    @ColumnInfo(name = "title")
    private String title = "";

    @ColumnInfo(name = "author")
    private String author = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
