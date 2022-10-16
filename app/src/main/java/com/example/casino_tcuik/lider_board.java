package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class lider_board extends AppCompatActivity {

    public static final String BONUS_MAGAZINE = "934875934750328475384";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lider_board);
        // получаем данные с другого активити
        Bundle arguments = getIntent().getExtras();
        int score = arguments.getInt(MainActivity.SCORE);

    }
}