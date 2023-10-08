package com.example.practica51_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
   TextView j1,j2,contrein;
   Button botonreiniciar,botonregresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        botonreiniciar = (Button) findViewById(R.id.botonreiniciar);
        botonregresar = (Button) findViewById(R.id.btnregresar);
        botonregresar.setOnClickListener(this);
        botonreiniciar.setOnClickListener(this);
        j1= (TextView) findViewById(R.id.j1);
        j2=(TextView) findViewById(R.id.j2);
        contrein=(TextView) findViewById(R.id.contrein);
        if (bundle != null) {
            String ganador = bundle.getString("ganador");
            int puntosjugador1 = bundle.getInt("j1");
            int puntosjugador2 = bundle.getInt("j2");

            j1.setText("Jugador 1: " + puntosjugador1);
            j2.setText("Jugador 2: " + puntosjugador2);
        }



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.botonreiniciar)
        {
            new CountDownTimer(6000, 1000)
            {
                public void onTick(long millisUntilFinished) {
                    contrein.setText("Regresando en: " + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    Intent intent = new Intent(MainActivity3.this,MainActivity.class);
                    intent.putExtra("reiniciar",true);
                    startActivity(intent);
                }
            }.start();

        } else if (v.getId()==R.id.btnregresar) {
            Intent intent = new Intent(MainActivity3.this,MainActivity.class);
            startActivity(intent);
        }
    }
}