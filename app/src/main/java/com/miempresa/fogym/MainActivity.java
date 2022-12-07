package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //TextView id,userName,userEmail,gender;
    EditText edtPeso, edtAltura;
    TextView txtImc, txtInfrapeso, txtNormal, txtSobrepeso, txtObesidad1, txtObesidad2, txtObesidad3;
    Button btnLogout, btnCalcular, btnBorrar;
    float altura, peso, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            //id = findViewById(R.id.textViewId);
            //userName = findViewById(R.id.textViewUsername);
            //userEmail = findViewById(R.id.textViewEmail);
            //gender = findViewById(R.id.textViewGender);
            btnLogout = findViewById(R.id.buttonLogout);
            User user = SharedPrefManager.getInstance(this).getUser();

            //id.setText(String.valueOf(user.getId()));
            //userEmail.setText(user.getEmail());
            //gender.setText(user.getGender());
            //userName.setText(user.getName());

            btnLogout.setOnClickListener(this);
        }
        else{
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        edtPeso=(EditText)findViewById(R.id.peso);
        edtAltura=(EditText)findViewById(R.id.altura);
        txtImc=(TextView)findViewById(R.id.imc);
        txtInfrapeso=(TextView)findViewById(R.id.infrapeso);
        txtNormal=(TextView)findViewById(R.id.normal);
        txtSobrepeso=(TextView)findViewById(R.id.sobrepeso);
        txtObesidad1=(TextView)findViewById(R.id.obesidad1);
        txtObesidad2=(TextView)findViewById(R.id.obesidad2);
        txtObesidad3=(TextView)findViewById(R.id.obesidad3);
        btnCalcular=(Button)findViewById(R.id.calcular);
        btnBorrar=(Button)findViewById(R.id.borrar);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    peso = Float.parseFloat(edtPeso.getText().toString());
                    altura = Float.parseFloat(edtAltura.getText().toString());
                    imc = peso / (altura * altura);
                    txtImc.setText("IMC: " + redondear(imc));
                    borrar();
                    if (imc < 18.5) {
                        txtInfrapeso.setBackgroundColor(Color.parseColor("green"));
                        txtInfrapeso.setTextColor(Color.parseColor("black"));
                    }
                    if (imc >= 18.5 && imc < 25) {
                        txtNormal.setBackgroundColor(Color.parseColor("green"));
                        txtNormal.setTextColor(Color.parseColor("black"));
                    }
                    if (imc >= 25 && imc < 30) {
                        txtSobrepeso.setBackgroundColor(Color.parseColor("green"));
                        txtSobrepeso.setTextColor(Color.parseColor("black"));
                    }
                    if (imc >= 30 && imc < 35) {
                        txtObesidad1.setBackgroundColor(Color.parseColor("green"));
                        txtObesidad1.setTextColor(Color.parseColor("black"));
                    }
                    if (imc >= 35 && imc < 40) {
                        txtObesidad2.setBackgroundColor(Color.parseColor("green"));
                        txtObesidad2.setTextColor(Color.parseColor("black"));
                    }
                    if (imc >= 40) {
                        txtObesidad3.setBackgroundColor(Color.parseColor("green"));
                        txtObesidad3.setTextColor(Color.parseColor("black"));
                    }

                }catch (Exception e){

                }

            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
                edtPeso.setText("");
                edtAltura.setText("");
                txtImc.setText("IMC: ");
            }
        });

        txtInfrapeso.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Infrapeso.class);
                startActivity(nextScreen);

            }
        });
        txtNormal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Normal.class);
                startActivity(nextScreen);

            }
        });
        txtSobrepeso.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Sobrepeso.class);
                startActivity(nextScreen);

            }
        });
        txtObesidad1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Obesidad1.class);
                startActivity(nextScreen);

            }
        });
        txtObesidad2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Obesidad2.class);
                startActivity(nextScreen);

            }
        });
        txtObesidad3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), Obesidad3.class);
                startActivity(nextScreen);

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

    public void onClick(View view){
        if(view.equals(btnLogout)){
            SharedPrefManager.getInstance(getApplicationContext()).logout();
        }
    }

    public void borrar() {

        txtInfrapeso.setBackgroundColor(Color.parseColor("white"));
        txtInfrapeso.setTextColor(Color.parseColor("black"));

        txtNormal.setBackgroundColor(Color.parseColor("white"));
        txtNormal.setTextColor(Color.parseColor("black"));

        txtSobrepeso.setBackgroundColor(Color.parseColor("white"));
        txtSobrepeso.setTextColor(Color.parseColor("black"));

        txtObesidad1.setBackgroundColor(Color.parseColor("white"));
        txtObesidad1.setTextColor(Color.parseColor("black"));

        txtObesidad2.setBackgroundColor(Color.parseColor("white"));
        txtObesidad2.setTextColor(Color.parseColor("black"));

        txtObesidad3.setBackgroundColor(Color.parseColor("white"));
        txtObesidad3.setTextColor(Color.parseColor("black"));

    }
}