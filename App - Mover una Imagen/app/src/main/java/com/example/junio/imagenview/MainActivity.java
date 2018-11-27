package com.example.junio.imagenview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btArriba, btAbajo, btIzquierda, btDerecha;

    private ImageView imgMario;

    private Boolean goDerecha;
    private Boolean goIzquierda;
    private Boolean goArriba;
    private Boolean goAbajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btArriba = (Button) findViewById(R.id.btArriba);
        btAbajo = (Button) findViewById(R.id.btAbajo);
        btIzquierda = (Button) findViewById(R.id.btIzquierda);
        btDerecha = (Button) findViewById(R.id.btDerecha);

        imgMario = (ImageView) findViewById(R.id.imgMario);


        btDerecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        goDerecha = true;
                        Derecha(v);
                        break;

                    case MotionEvent.ACTION_UP:
                        goDerecha = false;
                        break;

                }

                return false;
            }
        });

        btIzquierda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        goIzquierda=true;
                        Izquierda(v);
                        break;

                    case MotionEvent.ACTION_UP:
                        goIzquierda = false;
                        break;
                }

                return false;
            }
        });

        btArriba.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        goArriba=true;
                        Arriba(v);
                        break;

                    case MotionEvent.ACTION_UP:
                        goArriba = false;
                        break;
                }

                return false;
            }
        });

        btAbajo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        goAbajo=true;
                        Abajo(v);
                        break;

                    case MotionEvent.ACTION_UP:
                        goAbajo = false;
                        break;
                }

                return false;
            }
        });
    }

    public void Derecha (View v){
        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (goDerecha){
                    imgMario.setX(imgMario.getX() + 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable, 0000);

    }

    public void Izquierda (View v){
        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (goIzquierda){
                    imgMario.setX(imgMario.getX() - 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable, 0000);

    }

    public void Arriba (View v){
        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (goArriba){
                    imgMario.setY(imgMario.getY() - 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable, 0000);

    }

    public void Abajo (View v){
        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (goAbajo){
                    imgMario.setY(imgMario.getY() + 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable, 0000);

    }
}
