package com.example.practica51_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button [][] buttons= new Button[3][3];
    boolean jugador1turn=true;
    int round=0;
    static int jugador1puntos=0;
    static int jugador2puntos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for(int i=0; i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                String buttonID="b_"+i+j;
                int resid= getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j] = findViewById(resid);
                buttons[i][j].setOnClickListener(this);
            }
        }



        boolean resetear=getIntent().getBooleanExtra("reiniciar",false);
        if(resetear)
        {
            resetGame();
        }


    }

    @Override
    public void onClick(View v)
    {
        if(!((Button) v).getText().toString().equals("")){
            return;
        }
        if(jugador1turn){
            ((Button) v).setText("x");
            ((Button) v).setTextSize(50);
        }
        else{
            ((Button) v).setText("o");
            ((Button) v).setTextSize(50);
        }
        round++;

        if(checkForWin())
        {
            if(jugador1turn)
            {
                jugador1gana();
            }
            else {
                jugador2gana();
            }
        } else if (round==9) {
            draw();
        }
        else {
            jugador1turn=!jugador1turn;
        }
    }

    public boolean checkForWin(){
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }


        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {
                return true;
            }
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true;
            }
        }


        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }

    public void jugador1gana(){
        jugador1puntos++;
        Toast.makeText(this,"Jugador 1 gana!",Toast.LENGTH_SHORT).show();

        resetBoard();

        Bundle bundle = new Bundle();
        bundle.putString("ganador", "jugador1");
        bundle.putInt("j1", jugador1puntos);
        bundle.putInt("j2", jugador2puntos);

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void jugador2gana(){
        jugador2puntos++;
        Toast.makeText(this,"Jugador 2 gana!",Toast.LENGTH_SHORT).show();

        resetBoard();

        Bundle bundle = new Bundle();
        bundle.putString("ganador", "jugador2");
        bundle.putInt("j1", jugador1puntos);
        bundle.putInt("j2", jugador2puntos);

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    public void draw(){
        Toast.makeText(this,"Empate",Toast.LENGTH_SHORT).show();
        resetBoard();
    }


    public void resetBoard(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                buttons[i][j].setText("");
            }
        }
        round=0;
        jugador1turn=true;
    }
    public void resetGame()
    {
        jugador2puntos=0;
        jugador1puntos=0;
        resetBoard();

    }
}