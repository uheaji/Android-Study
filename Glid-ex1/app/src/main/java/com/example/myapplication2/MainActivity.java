package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv_1);

        Glide
                .with(MainActivity.this)
                .load("https://picsum.photos/id/147/200/300")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(iv1);

    }
}