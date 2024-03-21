package com.example.programacionii;

//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
// import android.widget.Spinner;
// import android.widget.TextView;
// import android.widget.Toast;


//import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Button btnVal1;
    Button btnFort;
    FloatingActionButton fabCarrito;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVal1 = findViewById(R.id.btnVal1);
        btnFort = findViewById(R.id.btnFort);
        fabCarrito = findViewById(R.id.fabCarrito);

        btnVal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Valorant.class);
                startActivity(intent);


            }
        });
        fabCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Carrito.class);
                startActivity(intent);
            }
        });

        btnFort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fortnite.class);
                startActivity(intent);
            }
        });


    }
}