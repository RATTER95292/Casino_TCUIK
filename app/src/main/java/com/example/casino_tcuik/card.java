package com.example.casino_tcuik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class card extends AppCompatActivity {

    Button but;
    TextView balance;
    Bundle arguments = getIntent().getExtras();
    int score = arguments.getInt(MainActivity.SCORE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        but = (Button) findViewById(R.id.dialog_button);
        balance = (TextView) findViewById(R.id.balance);

        String stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
        balance.setText(getResources().getString(R.string.Balance) + " " + stavka1);

        Intent intent = getIntent();
        String choseBtn = intent.getStringExtra(MainActivity.CHOISES);


        if (Objects.equals(choseBtn, "1")){
            but.setText("Ввести");
        }else{
            but.setText("Вывести");
        }



    }
}