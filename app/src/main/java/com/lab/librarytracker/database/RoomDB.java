package com.lab.librarytracker.database;

import android.content.Context;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;
import com.lab.librarytracker.models.entities.Orders;
import com.lab.librarytracker.models.entities.Users;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Users.class, Orders.class, Books.class, Copies.class},
        version = 1, exportSchema = false
)

public abstract class RoomDB extends RoomDatabase {
    private static RoomDB database;
    private static String DATABASE_NAME = "LibraryTrackerDB";

    public synchronized static RoomDB getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        return database;
    }

    public abstract UserDao userDao();
    public abstract OrderDao orderDao();
    public abstract BookDao bookDao();
    public abstract CopyDao copyDao();
}
