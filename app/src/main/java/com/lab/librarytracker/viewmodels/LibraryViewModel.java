package com.lab.librarytracker.viewmodels;

import android.app.Application;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Users;
import com.lab.librarytracker.repositories.LibraryRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class LibraryViewModel extends AndroidViewModel {

    private LibraryRepository mRepository;

    private final LiveData<List<Books>> mAllBooks;

    public LibraryViewModel(@NonNull Application application) {
        super(application);

        mRepository = new LibraryRepository(application);
        mAllBooks = mRepository.getAllBooks();
    }

    public LiveData<List<Books>> getmAllBooks() { return mAllBooks; }

    public void insert(Books book) { mRepository.insert(book); }

}
