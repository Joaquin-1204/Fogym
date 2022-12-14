package com.miempresa.fogym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

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

        ImageCarousel carousel = findViewById(R.id.carrusel);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> list = new ArrayList<>();
        list.add(
                new CarouselItem(
                        "https://recetascocinaperuana.com/wp-content/uploads/2021/06/causa-limena.jpg"
                )
        );
        list.add(
                new CarouselItem(
                        "https://www.perudelights.com/wp-content/uploads/2013/01/Picarones.jpg"
                )
        );
        list.add(
                new CarouselItem(
                        "https://www.peru.travel/Contenido/General/Imagen/pe/538/1.1/arroz-chaufa.jpg"
                )
        );
        carousel.setData(list);
    }
}