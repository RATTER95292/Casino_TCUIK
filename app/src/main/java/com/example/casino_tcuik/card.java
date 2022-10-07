package com.example.casino_tcuik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class card extends AppCompatActivity {

    Button but;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Intent intent = getIntent();
        String choseBtn = intent.getStringExtra(MainActivity.CHOISES);
        but = (Button) findViewById(R.id.dialog_button);

        if (choseBtn == "1"){
            but.setText("@string/input");
        }else{
            but.setText("@string/conclusion");
        }



    }
}