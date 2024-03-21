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
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 500 Valorant Points ($4.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 1,000 Valorant Points ($9.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 2,050 Valorant Points ($19..99)", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 3,650 Valorant Points ($34.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 5,350 Valorant Points ($49.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 11,000 Valorant Points ($99.99)", Toast.LENGTH_LONG).show();
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
