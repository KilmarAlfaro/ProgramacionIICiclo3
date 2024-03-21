package com.example.programacionii;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Message;

import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

Button btnInicio3;
Button btnPagar;
ListView listView;
String seleccion;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);
        listView = findViewById(R.id.listView);
        String seleccion = getIntent().getStringExtra("seleccion");

        ArrayList<String> obtenerItems;


        listView.setAdapter(adapter);

        (String seleccion){
            ArrayList<String> items;
            items = new ArrayList<>();

            switch (seleccion) {
                case "Opción 1":
                    items.add("1000 V-BUCKS");
                    items.add("Elemento 2");
                    break;
                case "Opción 2":
                    items.add("Elemento 3");
                    items.add("Elemento 4");
                    break;
                // Agrega más casos según sea necesario
            }
            return items;
        }

        btnInicio3 = findViewById(R.id.btnInicio3);

        btnInicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Carrito.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private Object obtenerItems(String seleccion) {

    }
}
