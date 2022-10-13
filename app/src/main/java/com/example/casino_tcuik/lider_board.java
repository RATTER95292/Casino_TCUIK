package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class lider_board extends AppCompatActivity {


    Bundle arguments = getIntent().getExtras();
    int score = arguments.getInt(MainActivity.SCORE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lider_board);
    }
}