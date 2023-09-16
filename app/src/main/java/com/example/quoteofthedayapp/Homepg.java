package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homepg extends AppCompatActivity {
    RecyclerView rcv;
    adapter myadapter;
    private List<String> favoriteQuotesList = new ArrayList<>(); // Add this line
    private String[] quotes = {
            "The Hardest Thing to learn in life is which bridge to cross and which to Burn -BERTRAND RUSSELL",
            "The meaning of life is to find your gift. The purpose of life is to give it away -PABLO PICASSO",
            "The highest form of love is to be the protector of another person's solitude -RAINER MARIA RILKE",
            "Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa",
            "Life is like riding a bicycle. To keep your balance, you must keep moving. -Albert Einstein",
            "Let everything happen to you. Beauty and terror. Just keep going. No feeling is final -RAINER MARIA RILKE",
            "The whole problem with the world is that fools and fanatics are always so certain of themselves, and wiser people so full of doubts -BERTRAND RUSSELL",
            "Imagination is more important than knowledge. -Albert Einstein"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepg);
        rcv=(RecyclerView) findViewById(R.id.rcview);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        myadapter = new adapter( dataqueue(),getApplicationContext());
        rcv.setAdapter(myadapter);
    }
    public ArrayList<model> dataqueue() {
        ArrayList<model> holder = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) { // Generate 7 random quotes
            int randomIndex = random.nextInt(quotes.length);
            String randomQuote = quotes[randomIndex];
            String[] parts = randomQuote.split("-");
            String authorName = parts[0].trim();
            String quoteText = parts[1].trim();

            model ob = new model();
            ob.setDesc("- " + authorName);
            ob.setHeader(quoteText);
            holder.add(ob);
        }
        return holder;
    }


}

