package com.lab.librarytracker.repositories;

import android.app.Application;

import com.lab.librarytracker.database.BookDao;
import com.lab.librarytracker.database.CopyDao;
import com.lab.librarytracker.database.OrderDao;
import com.lab.librarytracker.database.RoomDB;
import com.lab.librarytracker.database.UserDao;
import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;
import com.lab.librarytracker.models.entities.Orders;
import com.lab.librarytracker.models.entities.Users;

import java.util.List;

import androidx.lifecycle.LiveData;

public class LibraryRepository {
    private UserDao mUserDao;
    private OrderDao mUOrderDao;
    private BookDao mBookDao;
    private CopyDao mCopyDao;

    private LiveData<List<Users>> mAllUsers;
    private LiveData<List<Orders>> mAllOrders;
    private LiveData<List<Books>> mAllBooks;
    private LiveData<List<Copies>> mAllCopies;

    public LibraryRepository(Application application) {
        RoomDB db = RoomDB.getInstance(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.loadAllBooks();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Books>> getAllBooks() {
        return mAllBooks;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Books book) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            mBookDao.insertBook(book);
        });
    }

}
