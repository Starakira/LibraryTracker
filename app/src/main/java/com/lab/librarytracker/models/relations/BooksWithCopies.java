package com.lab.librarytracker.models.relations;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class BooksWithCopies {
    @Embedded
    public Books books;

    @Relation(parentColumn = "id", entityColumn = "bookId")
    public List<Copies> bookCopies;
}
