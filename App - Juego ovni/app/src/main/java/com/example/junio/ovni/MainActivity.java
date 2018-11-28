package com.example.junio.ovni;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btIzquierda, btDerecha;
    private Button btInicio, btDisparar;
    private ImageView imgOvni, imgMisil, imgExplocion;

    private Boolean goDerecha;
    private Boolean goIzquierda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIzquierda = (Button) findViewById(R.id.btIzquierda);
        btDerecha = (Button) findViewById(R.id.btDerecha);

        imgMisil = (ImageView) findViewById(R.id.imgMisil);

        btIzquierda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN :
                        goIzquierda = true;
                        moverIzquierda(v);
                        break;

                    case MotionEvent.ACTION_UP :
                        goIzquierda = false;
                        break;
                }

                return false;
            }
        });

        btDerecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN :
                        goDerecha = true;
                        moverDerecha(v);
                        break;

                    case MotionEvent.ACTION_UP :
                        goDerecha = false;
                        break;
                }

                return false;
            }
        });

    }

    private void moverIzquierda (View v){

        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(goIzquierda){
                    imgMisil.setX(imgMisil.getX() - 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable,0000);

    }

    private void moverDerecha(View v){
        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(goDerecha){
                    imgMisil.setX(imgMisil.getX() + 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable,0000);
    }
}
