package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class FavouriteQuote extends AppCompatActivity {
    RecyclerView recyclerView;
    FavouriteQuoteAdapter favouriteQuoteAdapter;
    List<String> favoriteQuotesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_quote);
        favoriteQuotesList = getIntent().getStringArrayListExtra("favoriteQuotesList");

        recyclerView = findViewById(R.id.recycler_view_favorite_quotes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favouriteQuoteAdapter = new FavouriteQuoteAdapter(favoriteQuotesList,this);
        recyclerView.setAdapter(favouriteQuoteAdapter);
    }
}