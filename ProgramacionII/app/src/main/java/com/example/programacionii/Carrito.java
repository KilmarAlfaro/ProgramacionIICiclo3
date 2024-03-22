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


        ArrayList<String> carritoItems = getFromSharedPreferences();


        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carritoItems);
        listView.setAdapter(adapter);

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeFromSharedPreferences();


                Toast.makeText(getApplicationContext(), "El pago se ha realizado con éxito", Toast.LENGTH_SHORT).show();


                carritoItems.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }


    private ArrayList<String> getFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);

        Set<String> carritoItemsSet = sharedPreferences.getStringSet("carrito_items", new HashSet<String>());

        return new ArrayList<>(carritoItemsSet);
    }

    private void removeFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("carrito_items");
        editor.apply();
    }
}