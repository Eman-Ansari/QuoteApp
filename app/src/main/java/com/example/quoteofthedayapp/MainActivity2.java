package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ImageView img;
    TextView tv1,tv2;
    private Button shareButton;
    private Button favouriteButton;
    private List<String> favoriteQuotesList = new ArrayList<>(); // Initialize an empty list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        shareButton = findViewById(R.id.shareButton);
        favouriteButton = findViewById(R.id.favouriteButton);
        tv1.setText(getIntent().getStringExtra("header"));
        tv2.setText(getIntent().getStringExtra("description"));
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String favoriteQuoteText = tv1.getText().toString() + "\n" + tv2.getText().toString();
                favoriteQuotesList.add(favoriteQuoteText);
                Toast.makeText(MainActivity2.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, FavouriteQuote.class);
                intent.putStringArrayListExtra("favoriteQuotesList", (ArrayList<String>) favoriteQuotesList);
                startActivity(intent);
            }

        });
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });
    }
    private void shareQuote() {
        String quoteText1 = tv1.getText().toString();
        String quoteText2 = tv2.getText().toString();
        // Combine both text values into a single string
        String combinedText = quoteText1 + "\n" + quoteText2;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, combinedText);
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }
}

