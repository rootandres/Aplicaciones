package com.example.junio.ovni;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btIzquierda, btDerecha;
    private Button btInicio, btDisparar;
    private ImageView imgOvni, imgMisil, imgExplocion;

    private Boolean goDerecha;
    private Boolean goIzquierda;

    private int altoPantalla;
    private int anchoPantalla;

    private TextView idText;

    private float posXinicial, posYinicial;

    private  Boolean datosIniciales = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIzquierda = (Button) findViewById(R.id.btIzquierda);
        btDerecha = (Button) findViewById(R.id.btDerecha);

        imgMisil = (ImageView) findViewById(R.id.imgMisil);

        idText = (TextView) findViewById(R.id.idText);

        inicio();


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

    private void  inicio(){

        // Capturamos ancho y alto de pantalla en pixeles

        Point size = new Point();
        Display display = getWindowManager().getDefaultDisplay();

        display.getSize(size);
        anchoPantalla = size.x;
        altoPantalla = size.y;

        posXinicial = imgMisil.getX();
        posYinicial = imgMisil.getY();

        idText.setText("Inicio: X"+posXinicial+" Iniicio Y: "+posYinicial);

    }

    private void moverIzquierda (View v){

        final Handler actualizar = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(goIzquierda){
                    if (imgMisil.getX() > 0)
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
                    if ( (imgMisil.getX() + imgMisil.getWidth() ) < anchoPantalla)
                        imgMisil.setX(imgMisil.getX() + 10);
                }
                actualizar.postDelayed(this,200);
            }
        };

        actualizar.postDelayed(runnable,0000);
    }
}
