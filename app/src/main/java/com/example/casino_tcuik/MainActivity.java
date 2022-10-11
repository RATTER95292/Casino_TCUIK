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
    public static final String CHOISES = "hhh";
    public static final String SCORE = "hhh";

    String choseBtn = " ";
    TextView score1,itog;
    EditText money;
    Button play,input,cut;
    int score = 1000;
    double a = 0.1;



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
            // Переход в магазин
            case R.id.main_magazine:
                Intent intent = new Intent(this, magazine.class);
                startActivity(intent);
                return true;

            // переход в рейтинг
            case R.id.lider_board:
                Intent intent1 = new Intent(this, lider_board.class);
                startActivity(intent1);
                return true;
            // о корпорации
            case R.id.corporation:
                Intent intent2 = new Intent(this, corporations.class);
                startActivity(intent2);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public int Random(int score){
        int max=100;
        int min=2;
        int x = (int) (Math.random()*(((max-min)+1))+min);
        double kvant = Math.random();
        a += 0.2;
        if (a == 0.9){
            a = 0.1;
        }
        if (kvant > a){
            kvant = Math.random();
            if (kvant > (a + 0.2) ) {
                score = score * x;
                return score;
            } else {
                score = score + x;
                return score;
                }
        }else{
            kvant = Math.random();
            if (kvant > a + 0.2) {
                score = score/x;
                return score;
            } else {
                score = score - x;
                return score;
            }
        }
    }

    public void Play(View v){
        int stavka = 0;
        score = score - stavka;
        try{
            stavka = Integer.parseInt(money.getText().toString());
            int score_qest = score - stavka;
            if(score_qest < 0 || stavka < 100 ) {
                Toast.makeText(this, getResources().getString(R.string.error_messege), Toast.LENGTH_LONG).show();
                return;
            }
        }catch (NumberFormatException e){
            Toast.makeText(this,getResources().getString(R.string.error_messege),Toast.LENGTH_LONG).show();
            itog.setText("");
            return;
        }
        int itog_stavka =  Math.abs(Random(stavka));

        String stavka1 = getResources().getQuantityString(R.plurals.money, itog_stavka, itog_stavka);
        Random objGenerator =  new Random();
        int randomNumber = 0;
        randomNumber = objGenerator.nextInt(4);

        if ( randomNumber >= 2){
            itog.setText(getResources().getString(R.string.Win) + " " + stavka1);
            score = score + itog_stavka;
        }else{
            score = score - stavka;
            String stav = getResources().getQuantityString(R.plurals.money, stavka, stavka);
            itog.setText(getResources().getString(R.string.Lose)+""+stav);
        }

        String score_rub = getResources().getQuantityString(R.plurals.money, score, score);

        score1.setText(getResources().getString(R.string.Balance) + " " + score_rub);


    }

    public void Click(View v){
        Intent intent = new Intent(this, card.class);
        if (v.getId() == R.id.inp)
        {
            choseBtn = "1";
        }
        else{
            choseBtn = "0";
        }

        intent.putExtra(CHOISES, choseBtn);
        intent.putExtra(SCORE,score);
        startActivityForResult(intent, Integer.parseInt(SCORE));
        startActivity(intent);
    }
}