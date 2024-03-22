package com.example.programacionii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Valorant extends AppCompatActivity {
    Button btnValo;
    Spinner spnValorant;
    FloatingActionButton fabCarrito;
    Button btnInicio;

    // Nombre para las SharedPreferences
    private static final String SHARED_PREFS_KEY = "carrito_items";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valorant);

        spnValorant = findViewById(R.id.spnValorant);
        btnValo = findViewById(R.id.btnValo);
        fabCarrito = findViewById(R.id.fabCarrito);
        btnInicio = findViewById(R.id.btnInicio);

        btnValo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la opción seleccionada en el Spinner
                int selectedItemPosition = spnValorant.getSelectedItemPosition();

                // Guardar el elemento seleccionado en las SharedPreferences
                saveToSharedPreferences(selectedItemPosition);

                // Mostrar un mensaje al usuario
                switch (selectedItemPosition) {
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

        fabCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Valorant.this, Carrito.class);
                startActivity(intent);
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Valorant.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para guardar elementos en las SharedPreferences
    private void saveToSharedPreferences(int selectedItemPosition) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Set<String> carritoItems = sharedPreferences.getStringSet("carrito_items", new HashSet<String>());

        // Agregar el nuevo elemento al set
        switch (selectedItemPosition) {
            case 1:
                carritoItems.add("500 Valorant Points ($4.99)");
                break;
            case 2:
                carritoItems.add("1,000 Valorant Points ($9.99)");
                break;
            case 3:
                carritoItems.add("2,050 Valorant Points ($19.99)");
                break;
            case 4:
                carritoItems.add("3,650 Valorant Points ($34.99)");
                break;
            case 5:
                carritoItems.add("5,350 Valorant Points ($49.99)");
                break;
            case 6:
                carritoItems.add("11,000 Valorant Points ($99.99)");
                break;
        }

        editor.putStringSet("carrito_items", carritoItems);
        editor.apply();
    }
}