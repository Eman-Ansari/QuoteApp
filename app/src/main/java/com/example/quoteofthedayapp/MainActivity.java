package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2;
    Animation anim1,anim2;
    private static int SPLASH_SCREEN=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);

        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
        textView1.setAnimation(anim1);
        textView2.setAnimation(anim2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Homepg.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        textView2.setAnimation(anim2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Homepg.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
