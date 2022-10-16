package com.example.casino_tcuik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class card extends AppCompatActivity {

    public static final String SCORE_CARD = "6286415726843718617569362472726775462769";
    public static final String BONUS_CARD = "934875934750328475384";

    Button but;
    TextView balance;
    String choseBtn="";
    String stavka1 = "";
    EditText edit_sum, card1, card2, card3, card4;
    int score;
    boolean bonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        but = (Button) findViewById(R.id.dialog_button);
        balance = (TextView) findViewById(R.id.balance);
        edit_sum = (EditText)findViewById(R.id.editText4);
        card1 = (EditText)findViewById(R.id.editText);
        card2 = (EditText)findViewById(R.id.editText1);
        card3 = (EditText)findViewById(R.id.editText3);
        card4 = (EditText)findViewById(R.id.editText4);

        //получение да нных с другого актива
        Bundle arguments = getIntent().getExtras();
        choseBtn =arguments.get(MainActivity.CHOISES).toString();
        but.setText(choseBtn);
        score = arguments.getInt(MainActivity.SCORE);

        String stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
        balance.setText(getResources().getString(R.string.Balance) + " " + stavka1);

       if (choseBtn.equals("1")){
            but.setText("Ввести");
        }else{
            but.setText("Вывести");
        }
    }


    public void inp_con(View view){

        int input;

        try{
            input = Integer.parseInt(edit_sum.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(this,getResources().getString(R.string.error_messege),Toast.LENGTH_LONG).show();
            return;
        }
        if (choseBtn.equals("1")){
            but.setText("Ввести");
            if (input <= 600){
                score = score + input;
            }else{
                score = 0;
                Toast.makeText(this,getResources().getString(R.string.error_messege1),Toast.LENGTH_LONG).show();
            }

            stavka1 = getResources().getQuantityString(R.plurals.money, score, score);
            balance.setText(getResources().getString(R.string.Balance) + " " + stavka1);

            //передача данных на другой актив
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(SCORE_CARD,score);
            bonus = true;
            intent.putExtra(BONUS_CARD,bonus);
            startActivity(intent);

        }else{
            try{
                int card = Integer.parseInt(card2.getText().toString());
                Toast.makeText(this, getResources().getString(R.string.error_messege2), Toast.LENGTH_LONG).show();
                return;
            }catch (NumberFormatException e){
                Toast.makeText(this,getResources().getString(R.string.error_messege3),Toast.LENGTH_LONG).show();
                return;
            }
        }


    }

}