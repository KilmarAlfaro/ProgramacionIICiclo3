package com.example.programacionii;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Message;

import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Carrito extends AppCompatActivity {

Button btnIncio;
Button btnPagar;
FloatingActionButton fabCarrito;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);
        btnIncio.findViewById(R.id.btnInicio);
        btnIncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Carrito.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



}
