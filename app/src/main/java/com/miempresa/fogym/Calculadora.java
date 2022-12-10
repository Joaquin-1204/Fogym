package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

    float alturac, pesoc, imcc;
    @Override
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        LinearLayout inicio = findViewById(R.id.inicio);
        LinearLayout estado = findViewById(R.id.mi_estado);
        EditText peso = findViewById(R.id.txtpeso);
        EditText altura = findViewById(R.id.txtaltura);
        Button calcular = findViewById(R.id.btnCalcular);
        Button recomendar = findViewById(R.id.btnRecomendacion);
        Button borrar  = findViewById(R.id.btnBorrar);
        TextView imc = findViewById(R.id.imc);
        TextView estadof  = findViewById(R.id.estadof);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    pesoc = Float.parseFloat(peso.getText().toString());
                    alturac = Float.parseFloat(altura.getText().toString());
                    imcc = pesoc / (alturac * alturac);
                    imc.setText("IMC: " + redondear(imcc));
                    if (imcc < 18.5) {
                        estadof.setText("Infrapeso");
                    }
                    if (imcc >= 18.5 && imcc < 25) {
                        estadof.setText("Normal");
                    }
                    if (imcc >= 25 && imcc < 30) {
                        estadof.setText("Sobrepeso");
                    }
                    if (imcc >= 30 && imcc < 35) {
                        estadof.setText("Obsidad 1");
                    }
                    if (imcc >= 35 && imcc < 40) {
                        estadof.setText("Obsidad 2");
                    }
                    if (imcc >= 40) {
                        estadof.setText("Obesidad3");
                    }

                }catch (Exception e){

                }

            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peso.setText("");
                altura.setText("");
                imc.setText("IMC");
                imcc = 0;
            }
        });

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
        recomendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (imcc < 18.5 && imcc > 0) {
                        Intent nextScreen = new Intent(Calculadora.this, Infrapeso.class);
                        startActivity(nextScreen);
                    }
                    if (imcc >= 18.5 && imcc < 25) {
                        Intent nextScreen = new Intent(Calculadora.this, Normal.class);
                        startActivity(nextScreen);
                    }
                    if (imcc >= 25 && imcc < 30) {
                        Intent nextScreen = new Intent(Calculadora.this, Sobrepeso.class);
                        startActivity(nextScreen);
                    }
                    if (imcc >= 30 && imcc < 35) {
                        Intent nextScreen = new Intent(Calculadora.this, Obesidad1.class);
                        startActivity(nextScreen);
                    }
                    if (imcc >= 35 && imcc < 40) {
                        Intent nextScreen = new Intent(Calculadora.this, Obesidad2.class);
                        startActivity(nextScreen);
                    }
                    if (imcc >= 40) {
                        Intent nextScreen = new Intent(Calculadora.this, Obesidad3.class);
                        startActivity(nextScreen);
                    }
                    if (imcc <= 0) {
                        Toast.makeText(Calculadora.this, "Ingrese los datos requeridos!",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {

                }
            }
        });
    }
    public float redondear(float n){
        float res;
        int valor=0;
        valor=(int)(n*100);
        res=(float)valor/100;
        return res;
    }
}