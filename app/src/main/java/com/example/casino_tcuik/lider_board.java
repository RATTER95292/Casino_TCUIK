package com.example.casino_tcuik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class lider_board extends AppCompatActivity {

    public static final String BONUS_MAGAZINE = "934875934750328475384";


    ListView list;
    ArrayList<lider_spisok> listLider = new ArrayList<lider_spisok>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lider_board);
        // получаем данные с другого активити
        Bundle arguments = getIntent().getExtras();
        int score = arguments.getInt(MainActivity.SCORE);

    }
    private void setInitialData(){
        listLider.add(new lider_spisok( R.drawable.k , "Илон маск",100000));
    }
}