package com.example.programacionii;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Carrito extends AppCompatActivity {

    Button btnInicio3;
    Button btnPagar;
    ListView listView;

    // Nombre para las SharedPreferences
    private static final String SHARED_PREFS_KEY = "carrito_items";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        listView = findViewById(R.id.listView);
        btnInicio3 = findViewById(R.id.btnInicio3);
        btnPagar = findViewById(R.id.btnPagar);

        btnInicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Obtener los elementos guardados en las SharedPreferences
        ArrayList<String> carritoItems = getFromSharedPreferences();

        // Crear el adapter y configurar el ListView
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carritoItems);
        listView.setAdapter(adapter);

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar los elementos de las SharedPreferences
                removeFromSharedPreferences();

                // Notificar al usuario que el pago se ha realizado con éxito
                Toast.makeText(getApplicationContext(), "El pago se ha realizado con éxito", Toast.LENGTH_SHORT).show();

                // Limpiar la lista y notificar al adapter
                carritoItems.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }

    // Método para obtener los elementos de las SharedPreferences
    private ArrayList<String> getFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);

        Set<String> carritoItemsSet = sharedPreferences.getStringSet("carrito_items", new HashSet<String>());

        // Convertir el Set a un ArrayList
        return new ArrayList<>(carritoItemsSet);
    }

    // Método para eliminar los elementos de las SharedPreferences
    private void removeFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("carrito_items");
        editor.apply();
    }
}