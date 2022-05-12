package com.lab.librarytracker.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lab.librarytracker.R;
import com.lab.librarytracker.database.DummyDBGenerator;
import com.lab.librarytracker.database.RoomDB;
import com.lab.librarytracker.helper.BooksListAdapter;
import com.lab.librarytracker.viewmodels.LibraryViewModel;

public class MainActivity extends AppCompatActivity {

    private RoomDB mDb;

    private LibraryViewModel mLibraryViewModel;

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        final BooksListAdapter adapter = new BooksListAdapter(new BooksListAdapter.BooksDiff());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLibraryViewModel = new ViewModelProvider(this).get(LibraryViewModel.class);

        mLibraryViewModel.getmAllBooks().observe(this, books -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(books);
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}