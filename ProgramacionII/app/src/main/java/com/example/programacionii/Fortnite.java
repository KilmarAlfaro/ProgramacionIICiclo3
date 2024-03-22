package com.example.programacionii;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Fortnite extends AppCompatActivity {
    Button btnInicio;
    Button btnFort;
    FloatingActionButton fabCarrito;
    Spinner spnFortnite;


    private static final String SHARED_PREFS_KEY = "carrito_items";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortnite);

        fabCarrito = findViewById(R.id.fabCarrito);
        btnInicio = findViewById(R.id.btnInicio);
        spnFortnite = findViewById(R.id.spnFortnite);
        btnFort = findViewById(R.id.btnFort);

        btnFort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedItemPosition = spnFortnite.getSelectedItemPosition();

                saveToSharedPreferences(selectedItemPosition);


                switch (selectedItemPosition) {
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

    private void saveToSharedPreferences(int selectedItemPosition) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Set<String> carritoItems = sharedPreferences.getStringSet("carrito_items", new HashSet<String>());


        switch (selectedItemPosition) {
            case 1:
                carritoItems.add("1,000 V-BUCKS ($8.99)");
                break;
            case 2:
                carritoItems.add("2,800 V-BUCKS ($19.99)");
                break;
            case 3:
                carritoItems.add("5,000 V-BUCKS ($31.99)");
                break;
            case 4:
                carritoItems.add("13,500 V-BUCKS ($79.99)");
                break;
        }

        editor.putStringSet("carrito_items", carritoItems);
        editor.apply();
    }
}