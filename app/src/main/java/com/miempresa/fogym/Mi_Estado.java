package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Mi_Estado extends AppCompatActivity {

    @Override
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_estado);
        LinearLayout calculadora = findViewById(R.id.calculadora);
        LinearLayout inicio = findViewById(R.id.inicio);

        calculadora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(Mi_Estado.this, Calculadora.class);
                startActivity(nextScreen);
            }
        });
        inicio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(Mi_Estado.this, Inicio.class);
                startActivity(nextScreen);

            }
        });
    }
}