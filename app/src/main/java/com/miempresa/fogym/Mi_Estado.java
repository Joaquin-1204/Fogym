package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Mi_Estado extends AppCompatActivity implements View.OnClickListener{

    TextView id,userName,userEmail,gender;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_estado);
        LinearLayout calculadora = findViewById(R.id.calculadora);
        LinearLayout inicio = findViewById(R.id.inicio);
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            //id = findViewById(R.id.textViewId);
            userName = findViewById(R.id.textViewUsername);
            userEmail = findViewById(R.id.textViewEmail);
            gender = findViewById(R.id.textViewGender);
            btnLogout = findViewById(R.id.buttonLogout);
            User user = SharedPrefManager.getInstance(this).getUser();

            //id.setText(String.valueOf(user.getId()));
            userEmail.setText(user.getEmail());
            gender.setText(user.getGender());
            userName.setText(user.getName());

            btnLogout.setOnClickListener(this);
        }
        else{
            Intent  intent = new Intent(Mi_Estado.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

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
    public void onClick(View view){
        if(view.equals(btnLogout)){
            SharedPrefManager.getInstance(getApplicationContext()).logout();
        }
    }
}