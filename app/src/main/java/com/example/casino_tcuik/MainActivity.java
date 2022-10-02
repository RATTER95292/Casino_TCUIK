package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView score1,itog;
    EditText money;
    Button play,input,cut;
    int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1 = (TextView)findViewById(R.id.score);
        itog = (TextView)findViewById(R.id.itog);
        money = (EditText)findViewById(R.id.money);
        play = (Button)findViewById(R.id.play);
        input = (Button)findViewById(R.id.inp);
        cut = (Button)findViewById(R.id.con);
        String end = getResources().getQuantityString(R.plurals.money, score, score);


    }

    public int Random(int score){
        int max=1;
        int min=100;
        int x = 0;
        double kvant;
        kvant = Math.random();
        x = (int) (Math.random()*(((max-min)+1))+min);
        if (score <= 1000) {
            if (kvant > 0.4){
                kvant = Math.random();
                if (kvant > 0.4) score = score*x;
                else score = score + x;
            }else{
                kvant = Math.random();
                if (kvant > 0.8) score = score/x;
                else score = score - x;
            }
        }else{
            if (kvant > 0.4){
                kvant = Math.random();
                if (kvant > 0.8) score = score*x;
                else score = score + x;
            }else{
                kvant = Math.random();
                if (kvant > 0.5) score = score/x;
                else score = score - x;
            }
        }
        return score;


    }

    public void Play(View v){
        int stavka = 0;
        try{
            stavka = Integer.parseInt(money.getText().toString());
        }catch (NumberFormatException e){

        }


    }

    public void Click(View v){
        Intent intent = new Intent(this, card.class);
        int choseBtn = 0;
        if (v.getId() == R.id.inp)
        {
            choseBtn = 1;
        }
        else{
            choseBtn = 2;
        }

        intent.putExtra("chose", choseBtn);
        startActivity(intent);
    }
}