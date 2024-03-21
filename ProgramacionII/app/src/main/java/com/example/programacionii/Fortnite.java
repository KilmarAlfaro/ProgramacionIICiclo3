package com.example.programacionii;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fortnite extends AppCompatActivity{
Button btnInicio;
Button btnFort;
FloatingActionButton fabCarrito;
Spinner spnFortnite;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortnite);
        fabCarrito = findViewById(R.id.fabCarrito);
        btnInicio= findViewById(R.id.btnInicio);
        spnFortnite = findViewById(R.id.spnFortnite);
        btnFort = findViewById(R.id.btnFort);

        btnFort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spnFortnite.getSelectedItemPosition()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Por favor seleccione un producto para agregarlo al carrito", Toast.LENGTH_LONG).show();

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 1,000 V-BUCKS ($8.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 2,800 V-BUCKS ($19.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 5,000 V-BUCKS ($31.99)", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Se ha agregado al carrito: 13,500 V-BUCKS ($79.99)", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fortnite.this, MainActivity.class);
                startActivity(intent);
            }
        });
        fabCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fortnite.this, Carrito.class);
                startActivity(intent);
            }
        });


    }


}
