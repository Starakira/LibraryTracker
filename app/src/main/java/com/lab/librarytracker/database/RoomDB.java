package com.lab.librarytracker.database;

import android.content.Context;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;
import com.lab.librarytracker.models.entities.Orders;
import com.lab.librarytracker.models.entities.Users;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {Users.class, Orders.class, Books.class, Copies.class},
        version = 1, exportSchema = false
)

public abstract class RoomDB extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract OrderDao orderDao();

    public abstract BookDao bookDao();

    public abstract CopyDao copyDao();

    private static volatile RoomDB INSTANCE;
    private static String DATABASE_NAME = "LibraryTrackerDB";

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public synchronized static RoomDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        return INSTANCE;
    }

    private static Books addBook(final RoomDB db, final int id, final String title) {
        Books book = new Books();
        book.setId(id);
        book.setTitle(title);
        db.bookDao().insertBook(book);
        return book;
    }
}
