package com.example.programacionii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Message;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Valorant extends AppCompatActivity{
    Button btnValo;
    Button btnInicio;
    Spinner spnValorant;
    Button btnCarrito;
    FloatingActionButton fabCarrito;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valorant);
        spnValorant = findViewById(R.id.spnValorant);
        btnValo = findViewById(R.id.btnValo);
        fabCarrito = findViewById(R.id.fabCarrito);


        btnValo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (spnValorant.getSelectedItemPosition()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Por favor seleccione un producto para agregarlo al carrito", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 600 Valorant Points ($6.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 1200 Valorant Points ($11.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 2500 Valorant Points ($26.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 5000 Valorant Points ($50.99)", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });


        btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Valorant.this, MainActivity.class);
                startActivity(intent);
            }
        });

        fabCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Valorant.this, Carrito.class);
                startActivity(intent);
            }
        });

    }
}
