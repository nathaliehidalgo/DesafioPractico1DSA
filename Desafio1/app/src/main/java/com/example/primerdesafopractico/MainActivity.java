package com.example.primerdesafopractico;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText a_value;
    EditText b_value;
    EditText c_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a_value = findViewById(R.id.a_value);
        b_value = findViewById(R.id.b_value);
        c_value = findViewById(R.id.c_value);

        Button calculate_button = findViewById(R.id.calculate_button);
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }


    private void calcular() {
        double a = Double.parseDouble(a_value.getText().toString());
        double b = Double.parseDouble(b_value.getText().toString());
        double c = Double.parseDouble(c_value.getText().toString());

        double potencia = Math.pow(b,2) - (4 * a *c);
        double x1 =  (-b - Math.sqrt(potencia))/ 2*a;
        double x2 = (-b + Math.sqrt(potencia))/ 2*a;

        new AlertDialog.Builder(this).setTitle("Resultados: ").setMessage("x1 = " + x1 + "\nx2 = " + x2).show();
    }

}