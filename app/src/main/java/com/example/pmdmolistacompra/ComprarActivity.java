package com.example.pmdmolistacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ComprarActivity extends AppCompatActivity {
    private String TAG = "seleccionado";
    private String seleccionado;
    private int opcion, totalComprado, prec;
    private int[] precio;
    private Spinner sp;
    private TextView tv;
    private Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        initComponents();
        initEvents();

        opcion = getIntent().getIntExtra(TAG, 0);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lacteos, android.R.layout.simple_spinner_item);;

    switch (opcion){
        case 0:
            adapter = ArrayAdapter.createFromResource(this, R.array.lacteos, android.R.layout.simple_spinner_item);
            precio = getResources().getIntArray(R.array.precioLacteos);
            break;
        case 1:
            adapter = ArrayAdapter.createFromResource(this, R.array.carne, android.R.layout.simple_spinner_item);
            precio = getResources().getIntArray(R.array.precioLacteos);
            break;
        case 2:
            adapter = ArrayAdapter.createFromResource(this, R.array.pescado, android.R.layout.simple_spinner_item);
            precio = getResources().getIntArray(R.array.precioLacteos);
            break;
        case 3:
            adapter = ArrayAdapter.createFromResource(this, R.array.verdura, android.R.layout.simple_spinner_item);
            precio = getResources().getIntArray(R.array.precioLacteos);
            break;
    }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                totalComprado += precio[position];
                tv.setText(Integer.toString(totalComprado));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
                sp.setSelection(0);
            }
        });
    }

    private void initComponents(){
        sp = findViewById(R.id.spinner);
        tv = findViewById(R.id.tvPrecio);
        btComprar = findViewById(R.id.btComprar);
    }

    private void initEvents(){
        final Intent i = new Intent(this, MainActivity.class);
        prec = getIntent().getIntExtra("total", 0);
        totalComprado += prec;
        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("total", totalComprado);
                startActivity(i);
            }
        });
    }

}
