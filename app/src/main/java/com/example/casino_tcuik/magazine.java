package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class magazine extends AppCompatActivity {


    public static final String SCORE1 = "score5";

    Button buy_button;
    TextView text_balance;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        buy_button = (Button)findViewById(R.id.buy_button);
        text_balance = (TextView)findViewById(R.id.text_balance);

        //полуаем данне с другого активити
        Bundle arguments = getIntent().getExtras();
        score = arguments.getInt(MainActivity.SCORE);
        String balance = getResources().getQuantityString(R.plurals.money, score, score);
        text_balance.setText(getResources().getString(R.string.Balance) + " " + balance);

    }

    public void buy_click(View view){

        //передача счета на другой активити
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(SCORE1,score);
        startActivity(intent);
    }
}