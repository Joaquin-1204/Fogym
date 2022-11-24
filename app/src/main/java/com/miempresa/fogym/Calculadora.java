package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Calculadora extends AppCompatActivity {

    @Override
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        LinearLayout inicio = findViewById(R.id.inicio);
        LinearLayout estado = findViewById(R.id.mi_estado);

        inicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(Calculadora.this, Inicio.class);
                startActivity(nextScreen);
            }
        });
        estado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(Calculadora.this, Mi_Estado.class);
                startActivity(nextScreen);
            }
        });
    }
}