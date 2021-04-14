package com.example.hellocompat;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //creamos nuestra variable para nuestro textView
    private TextView mHelloTextView;
    //arreglo que inluye todos los colores que dimos de alta en nuestro archvio colors.xml
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos el id del txtView de nuestro activity_main.xml
        mHelloTextView = findViewById(R.id.hello_textview);

        if(savedInstanceState!= null){
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }//fin del if

    }//fin del método onCreate

    /**
     * Método para guardar el color de nuesto txtView
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }//fin del método onSavedInstanceState

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void changeColor(View view) {
        //Creamos un numero aleatorio
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(colorName,"color", getApplicationContext().getPackageName());

        int colorRes = getResources().getColor(colorResourceName, this.getTheme());

        int colorRe = ContextCompat.getColor(this, colorResourceName);
        mHelloTextView.setTextColor(colorRe);
    }//fin del método changeColor
}//fin de la clase MainActivity