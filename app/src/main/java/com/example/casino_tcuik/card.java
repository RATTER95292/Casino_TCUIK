package com.example.casino_tcuik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class card extends AppCompatActivity {

    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Intent intent = getIntent();
        String choseBtn = intent.getStringExtra(MainActivity.CHOISES);
        but = (Button) findViewById(R.id.dialog_button);

        if (Objects.equals(choseBtn, "1")){
            but.setText("@string/input");
        }else{
            but.setText("@string/conclusion");
        }



    }
}