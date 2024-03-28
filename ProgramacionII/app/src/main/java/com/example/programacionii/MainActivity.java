package com.example.programacionii;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    RadioGroup opt;
    Spinner spn;

    TabHost tbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.TbhParcial);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("AGUA").setContent(R.id.TabTarifaAgua).setIndicator("AGUA", null));
        tbh.addTab(tbh.newTabSpec("AREA").setContent(R.id.TabConversor).setIndicator("AREA", null));

        btn = findViewById(R.id.BtnTarifaAgua);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtCantidadAgua);
                double mts = Double.parseDouble(tempVal.getText().toString());
                double tarifa = 0;

                if (mts >= 1 && mts <= 18) {
                    tarifa = 6;


                } else if (mts >= 19 && mts <= 28) {
                    tarifa = ((mts - 18) * 0.45) + 6;


                } else {

                    tarifa = (((mts - 28) * 0.65) + (28 - 18) * 0.45) + 6;
                }
                Toast.makeText(getApplicationContext(), "Su tarifa de agua es de: $" + tarifa, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
