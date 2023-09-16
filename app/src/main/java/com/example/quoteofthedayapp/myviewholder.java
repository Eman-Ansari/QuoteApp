package com.example.quoteofthedayapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView t1,t2;
    CardView cardview;

    public myviewholder(@NonNull View itemView)
    {
        super(itemView);
        img =(ImageView) itemView.findViewById(R.id.img1);
        t1= (TextView) itemView.findViewById(R.id.t1);
        t2= (TextView) itemView.findViewById(R.id.t2);
        cardview = itemView.findViewById(R.id.cardView);
    }
}

