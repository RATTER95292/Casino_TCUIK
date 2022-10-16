package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class magazine extends AppCompatActivity {


    public static final String SCORE_MAGAZINE = "score5";
    public static final String BONUS_MAGAZINE = "934875934750328475384";

    Button buy_button;
    TextView text_balance;
    ListView tovar_list;
    int score;
    boolean bonus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        buy_button = (Button)findViewById(R.id.buy_button);
        text_balance = (TextView)findViewById(R.id.text_balance);
        tovar_list = (ListView)findViewById(R.id.conturiesList);

        //полуаем данне с другого активити
        Bundle arguments = getIntent().getExtras();
        score = arguments.getInt(MainActivity.SCORE);
        String balance = getResources().getQuantityString(R.plurals.money, score, score);
        text_balance.setText(getResources().getString(R.string.Balance) + " " + balance);


        String[] tovar = getResources().getStringArray(R.array.magazine);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tovar);

        tovar_list.setAdapter(adapter);
        tovar_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    public void buy_click(View view){

        //передача счета на другой активити
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(SCORE_MAGAZINE,score);
        bonus = true;
        intent.putExtra(BONUS_MAGAZINE,bonus);
        startActivity(intent);
    }
}