package com.lab.librarytracker.helper;

import android.view.ViewGroup;

import com.lab.librarytracker.models.entities.Books;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class BooksListAdapter extends ListAdapter<Books, BooksViewHolder> {

    public BooksListAdapter(@NonNull DiffUtil.ItemCallback<Books> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BooksViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        Books current = getItem(position);
        holder.bind(current.getTitle());
    }

    public static class BooksDiff extends DiffUtil.ItemCallback<Books> {

        @Override
        public boolean areItemsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }

}
