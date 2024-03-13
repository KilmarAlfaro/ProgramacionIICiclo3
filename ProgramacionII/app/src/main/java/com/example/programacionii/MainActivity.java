package com.example.programacionii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button btnValo;
    Spinner  spnValorant;
    Button btnCarrito;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnValorant = findViewById(R.id.spnValorant);
        btnValo = findViewById(R.id.btnValo);
        btnValo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (spnValorant.getSelectedItemPosition()){
                case 0:
                    Toast.makeText(getApplicationContext(), "No se ha agregado nada al carrito", Toast.LENGTH_LONG).show();
                    break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_LONG).show();
                        break;

                }

            }
        });




    }
}