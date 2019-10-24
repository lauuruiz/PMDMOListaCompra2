package com.example.pmdmolistacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PagarActivity extends AppCompatActivity {
    private TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        tvTotal = findViewById(R.id.tvTotal);
        int precio = getIntent().getIntExtra("total", 0);
        tvTotal.setText("Total: "+precio+"€");
    }
}
