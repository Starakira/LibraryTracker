package com.lab.librarytracker.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab.librarytracker.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BooksViewHolder extends RecyclerView.ViewHolder {
    private final TextView userItemView;

    private BooksViewHolder(@NonNull View itemView) {
        super(itemView);
        userItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        userItemView.setText(text);
    }

    static BooksViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new BooksViewHolder(view);
    }

}
