package com.lab.librarytracker.database;

import android.os.AsyncTask;
import android.util.Log;

import com.lab.librarytracker.models.entities.Books;
import com.lab.librarytracker.models.entities.Copies;
import com.lab.librarytracker.models.entities.Orders;
import com.lab.librarytracker.models.entities.Users;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Room;

public class DummyDBGenerator {
    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final RoomDB db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final RoomDB db) {
        populateWithTestData(db);
    }

    private static void addOrder(final RoomDB db, final int id,
                                  final Users user, final Books book, final Copies copies, Date from, Date to) {
        Orders order = new Orders();
        order.setId(id);
        order.setOrderCopyId(copies.getId());
        order.setOrderUserId(user.getId());
        order.setOrderDate(from);
        order.setReturnDate(to);
        db.orderDao().insertOrders(order);
    }

    private static Books addBook(final RoomDB db, final int id, final String title) {
        Books book = new Books();
        book.setId(id);
        book.setTitle(title);
        db.bookDao().insertBook(book);
        return book;
    }

    private static Copies addCopy(final RoomDB db, final int id, final Books book) {
        Copies copy = new Copies();
        copy.setId(id);
        copy.setBookId(book.getId());
        db.copyDao().insertCopy(copy);
        return copy;
    }

    private static Users addUser(final RoomDB db, final int id, final String username,
                                final String lastName) {
        Users user = new Users();
        user.setId(id);
        user.setUsername(username);
        db.userDao().insertUser(user);
        return user;
    }

    private static void populateWithTestData(RoomDB db) {
        db.orderDao().deleteAll();
        db.userDao().deleteAll();
        db.bookDao().deleteAll();

        Users user1 = addUser(db, 1, "Jason", "Seaver");
        Users user2 = addUser(db, 2, "Mike", "Seaver");
        addUser(db, 3, "Carol", "Seaver");

        Books book1 = addBook(db, 1, "Dune");
        Books book2 = addBook(db, 2, "1984");
        Books book3 = addBook(db, 3, "The War of the Worlds");
        Books book4 = addBook(db, 4, "Brave New World");
        addBook(db, 5, "Foundation");

        Copies copy1 = addCopy(db, 1, book1);
        Copies copy2 = addCopy(db, 2, book2);
        Copies copy3 = addCopy(db, 3, book2);
        Copies copy4 = addCopy(db, 4, book3);
        Copies copy5 = addCopy(db, 5, book3);
        Copies copy6 = addCopy(db, 6, book3);
        addBook(db, 5, "Foundation");

        try {
            // Loans are added with a delay, to have time for the UI to react to changes.

            Date today = getTodayPlusDays(0);
            Date yesterday = getTodayPlusDays(-1);
            Date twoDaysAgo = getTodayPlusDays(-2);
            Date lastWeek = getTodayPlusDays(-7);
            Date twoWeeksAgo = getTodayPlusDays(-14);

            addOrder(db, 1, user1, book1, copy1, twoWeeksAgo, lastWeek);
            Thread.sleep(DELAY_MILLIS);
            addOrder(db, 2, user2, book1, copy2, lastWeek, yesterday);
            Thread.sleep(DELAY_MILLIS);
            addOrder(db, 3, user2, book2, copy3, lastWeek, today);
            Thread.sleep(DELAY_MILLIS);
            addOrder(db, 4, user2, book3, copy4, lastWeek, twoDaysAgo);
            Thread.sleep(DELAY_MILLIS);
            addOrder(db, 5, user2, book4, copy5, lastWeek, today);
            Log.d("DB", "Added loans");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Date getTodayPlusDays(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysAgo);
        return calendar.getTime();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final RoomDB mDb;

        PopulateDbAsync(RoomDB db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
