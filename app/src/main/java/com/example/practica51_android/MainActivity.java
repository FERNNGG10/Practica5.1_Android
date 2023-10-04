package com.example.practica51_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button [] btns = new Button[9];
    boolean jstatus;
    int[]gamestate={2,2,2,2,2,2,2,2,2};
    int[][]win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    int rounds;
    int jugador1,jugador2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns[0]=findViewById(R.id.c1);
        btns[1]=findViewById(R.id.c2);
        btns[2]=findViewById(R.id.c3);
        btns[3]=findViewById(R.id.c4);
        btns[4]=findViewById(R.id.c5);
        btns[5]=findViewById(R.id.c6);
        btns[6]=findViewById(R.id.c7);
        btns[7]=findViewById(R.id.c8);
        btns[8]=findViewById(R.id.c9);

        for(int i=0;i<btns.length;i++)
        {
            btns[i].setOnClickListener(this);
        }

        jugador1=0;
        jugador2=0;
        jstatus=true;
        rounds=0;
    }

    @Override
    public void onClick(View v)
    {
        String btnid= v.getResources().getResourceEntryName(v.getId());
        int gamestatepointer = Integer.parseInt(btnid.substring(btnid.length()-1,btnid.length()));
        if(jstatus)
        {
            ((Button)v).setBackgroundResource(R.drawable.equis);
            gamestate[gamestatepointer]=0;
        }
        else
        {
            ((Button)v).setBackgroundResource(R.drawable.circle);
            gamestate[gamestatepointer]=1;
        }
        rounds++;
        if(checkWinner)
        {
            if(jstatus)
            {
                jugador1++;
                updatePlayerScore();

            }
            else
            {

            }

        }

    }


}