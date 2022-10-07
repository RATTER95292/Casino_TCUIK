package com.example.casino_tcuik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String CHOISES = " ";
    public static final String SCORE = " ";

    TextView score1,itog;
    EditText money;
    Button play,input,cut;
    int score = 1000;



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

        Toast.makeText(this,getResources().getString(R.string.Bonus),Toast.LENGTH_LONG).show();

        String stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
        score1.setText(getResources().getString(R.string.Balance) + " " + stavka1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.main_magazine:
                // Переход в магазин
                return true;

            case R.id.lider_board:
                // переход в рейтинг
                return true;

            case R.id.corporation:
                // о корпорации
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public int Random(int score){
        int max=100;
        int min=2;
        int x;
        double kvant;
        kvant = Math.random();
        x = (int) (Math.random()*(((max-min)+1))+min);
        if (score <= 1000) {
            if (kvant > 0.4){
                kvant = Math.random();
                if (kvant > 0.4) {
                    score = score * x;
                } else {
                    score = score + x;
                }
            }else{
                kvant = Math.random();
                if (kvant > 0.8) {
                    score = score/x;
                } else {
                    score = score - x;
                }
            }
        }else{
            if (kvant > 0.4){
                kvant = Math.random();
                if (kvant > 0.8) {
                    score = score * x;
                }else {
                    score = score + x;
                }
            }else{
                kvant = Math.random();
                if (kvant > 0.5) {
                    score = score/x;
                } else {
                    score = score - x;
                }
            }
        }

        return score;


    }

    public void Play(View v){
        int stavka = 0;
        score = score - stavka;
        try{
            stavka = Integer.parseInt(money.getText().toString());
            int score_qest = score - stavka;
            if(score_qest < 0 || stavka < 0) {
                Toast.makeText(this, getResources().getString(R.string.error_messege), Toast.LENGTH_LONG).show();
                return;
            }
        }catch (NumberFormatException e){
            Toast.makeText(this,getResources().getString(R.string.error_messege),Toast.LENGTH_LONG).show();
            itog.setText("");
            return;
        }
        int itog_stavka = Random(stavka);

        String stavka1 = getResources().getQuantityString(R.plurals.money, itog_stavka, itog_stavka);
        Random objGenerator =  new Random();
        int randomNumber = 0;
        randomNumber = objGenerator.nextInt(2);

        if ( randomNumber > 1){
            itog.setText(getResources().getString(R.string.Win) + " " + stavka1);
            score = score + itog_stavka;
        }else{
            itog.setText(getResources().getString(R.string.Lose));
        }

        String score_rub = getResources().getQuantityString(R.plurals.money, score, score);

        score1.setText(getResources().getString(R.string.Balance) + " " + score_rub);

    }

    public void Click(View v){
        Intent intent = new Intent(this, card.class);
        String choseBtn = " ";
        if (v.getId() == R.id.inp)
        {
            choseBtn = "0";
        }
        else{
            choseBtn = "1";
        }

        intent.putExtra(CHOISES, choseBtn);
        intent.putExtra(SCORE,score);
        startActivity(intent);
    }
}