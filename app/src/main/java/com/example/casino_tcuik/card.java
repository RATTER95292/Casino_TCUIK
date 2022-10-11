package com.example.casino_tcuik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class card extends AppCompatActivity {

    Button but;
    TextView balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        but = (Button) findViewById(R.id.dialog_button);
        balance = (TextView) findViewById(R.id.balance);

        String choseBtn="";
        Bundle arguments = getIntent().getExtras();
        choseBtn =arguments.get(MainActivity.CHOISES).toString();
        Log.i ("btn",choseBtn);

        but.setText(choseBtn);
        int score = arguments.getInt(MainActivity.SCORE);
        String stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
        balance.setText(getResources().getString(R.string.Balance) + " " + stavka1);

       if (choseBtn.equals("1")){
            but.setText("Ввести");
        }else{
            but.setText("Вывести");
        }



    }
}