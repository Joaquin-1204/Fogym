package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class splash_fogym extends AppCompatActivity {

    Button btnempezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_fogym);

        btnempezar=(Button)findViewById(R.id.btnComenzar);

        btnempezar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(nextScreen);

            }
        });
    }
}