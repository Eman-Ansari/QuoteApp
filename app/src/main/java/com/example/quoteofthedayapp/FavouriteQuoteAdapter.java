package com.example.quoteofthedayapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouriteQuoteAdapter extends RecyclerView.Adapter<FavouriteQuoteAdapter.ViewHolder> {
    private List<String> favoriteQuotes;
    private Context context;

    public FavouriteQuoteAdapter(List<String> favoriteQuotes, Context context) {
            this.favoriteQuotes = favoriteQuotes;
            this.context = context;
            }

    @NonNull
    @Override
    public FavouriteQuoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_quote_item, parent, false);
            return new ViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull FavouriteQuoteAdapter.ViewHolder holder, int position) {
            String favoriteQuote = favoriteQuotes.get(position);
            holder.favoriteQuoteText.setText(favoriteQuote);
            }

    @Override
    public int getItemCount() {
            return favoriteQuotes.size();
            }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView favoriteQuoteText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favoriteQuoteText = itemView.findViewById(R.id.favorite_quote_text);
        }
    }
}