package com.example.pmdmolistacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int total = 0, totalParcial;
    private String TAG = "seleccionado";
    private RadioButton rbLacteos, rbCarne, rbPescado, rbVerduras;
    private Button btComprar, btPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initEvents();
    }

    private void initComponents(){
        rbLacteos = findViewById(R.id.rbLacteos);
        rbCarne = findViewById(R.id.rbCarne);
        rbPescado = findViewById(R.id.rbPescado);
        rbVerduras = findViewById(R.id.rbVerduras);
        btComprar = findViewById(R.id.btComprar);
        btPagar = findViewById(R.id.btPagar);
    }

    private void initEvents(){
            btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbLacteos.isChecked()){
                    Intent i = new Intent(MainActivity.this, ComprarActivity.class);
                    i.putExtra(TAG, 0);
                    i.putExtra("total", total);
                    startActivity(i);
                }else if(rbCarne.isChecked()){
                    Intent i = new Intent(MainActivity.this, ComprarActivity.class);
                    i.putExtra(TAG, 1);
                    i.putExtra("total", total);
                    startActivity(i);
                }else if(rbPescado.isChecked()){
                    Intent i = new Intent(MainActivity.this, ComprarActivity.class);
                    i.putExtra(TAG, 2);
                    i.putExtra("total", total);
                    startActivity(i);
                }else if(rbVerduras.isChecked()){
                    Intent i = new Intent(MainActivity.this, ComprarActivity.class);
                    i.putExtra(TAG, 3);
                    i.putExtra("total", total);
                    startActivity(i);
                }
            }
        });

        totalParcial = getIntent().getIntExtra("total", 0);
        total += totalParcial;

        btPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PagarActivity.class);
                i.putExtra("total", total);
                startActivity(i);
            }
        });
    }
}
