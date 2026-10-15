package com.example.calculadorapersonalizada;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int IMC = 0;
    private TextView txtPeso;
    private TextView txtAltura;
    private TextView txtIMC;
    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        Button calcular = findViewById(R.id.btnCalcular);
        txtIMC = findViewById(R.id.txtIMC);

        calcular.setOnClickListener(v -> {
            String pesoStr = txtPeso.getText().toString().trim().replace(",", ".");
            String alturaStr = txtAltura.getText().toString().trim().replace(",", ".");

            if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                Toast.makeText(this, "Rellena peso y altura", Toast.LENGTH_SHORT).show();
                return;
            }

            double peso = Double.parseDouble(pesoStr);
            double alturaM = Double.parseDouble(alturaStr);

            if (alturaM <= 0) {
                Toast.makeText(this, "La altura debe ser mayor que 0", Toast.LENGTH_SHORT).show();
                return;
            }

            double imc = peso / (alturaM * alturaM);

            txtIMC.setText(String.format("%.2f", imc));
        });
    }
}