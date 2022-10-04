package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView score1,itog;
    EditText money;
    Button play,input,cut;
    int score = 1000;

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
        itog.setText("");
        try{
            stavka = Integer.parseInt(money.getText().toString());
        }catch (NumberFormatException e){

            Toast.makeText(this,getResources().getString(R.string.error_messege),Toast.LENGTH_LONG).show();
            itog.setText("");
            return;

        }
        int itog_stavka = Random(stavka);
        int difference = score - itog_stavka;
        String stavka1 = getResources().getQuantityString(R.plurals.money, difference, difference);
        if (difference >= 0){
            itog.setText(getResources().getString(R.string.Win) + " " + stavka1);
        }else{
            itog.setText(getResources().getString(R.string.Lose) + " " + stavka1);
        }
        score = stavka + score;
        stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
        score1.setText(getResources().getString(R.string.Balance) + " " + stavka1);




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