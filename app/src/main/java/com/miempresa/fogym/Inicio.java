package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Inicio extends AppCompatActivity {

    @Override
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        LinearLayout calculadora = findViewById(R.id.calculadora);
        LinearLayout estado = findViewById(R.id.mi_estado);

        calculadora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(Inicio.this, Calculadora.class);
                startActivity(nextScreen);
            }
        });
        estado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(Inicio.this, Mi_Estado.class);
                startActivity(nextScreen);
            }
        });
    }
}