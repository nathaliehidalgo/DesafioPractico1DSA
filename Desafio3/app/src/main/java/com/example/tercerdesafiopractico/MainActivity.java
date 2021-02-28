package com.example.tercerdesafiopractico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tercerdesafiopractico.modelos.Empleado;

import java.util.ArrayList;

import static com.example.tercerdesafiopractico.ResultActivity.EXTRA_EMPLEADOS;

public class MainActivity extends AppCompatActivity {

    EditText nombresE1, apellidosE1, horasE1, nombresE2, apellidosE2, horasE2, nombresE3, apellidosE3, horasE3;
    AppCompatSpinner cargoE1, cargoE2, cargoE3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombresE1 = findViewById(R.id.nombres_e1);
        nombresE2 = findViewById(R.id.nombres_e2);
        nombresE3 = findViewById(R.id.nombres_e3);

        apellidosE1 = findViewById(R.id.apellidos_e1);
        apellidosE2 = findViewById(R.id.apellidos_e2);
        apellidosE3 = findViewById(R.id.apellidos_e3);

        horasE1 = findViewById(R.id.horas_e1);
        horasE2 = findViewById(R.id.horas_e2);
        horasE3 = findViewById(R.id.horas_e3);

        cargoE1 = findViewById(R.id.cargo_e1);
        cargoE2 = findViewById(R.id.cargo_e2);
        cargoE3 = findViewById(R.id.cargo_e3);

        Button calcularButton = findViewById(R.id.calculate_button);

        calcularButton.setOnClickListener(v -> calcular());
    }

    private void calcular() {

        int horasEmpleado1 = Integer.parseInt(horasE1.getText().toString());
        int horasEmpleado2 = Integer.parseInt(horasE2.getText().toString());
        int horasEmpleado3 = Integer.parseInt(horasE3.getText().toString());

        if (horasEmpleado1 > 0 && horasEmpleado2 > 0 && horasEmpleado3 > 0) {

            Bundle extras = new Bundle();
            ArrayList<Empleado> empleados = new ArrayList<>();

            Empleado empleado1 = new Empleado(nombresE1.getText().toString(),
                    apellidosE1.getText().toString(),
                    cargoE1.getSelectedItemPosition(),
                    horasEmpleado1
            );

            Empleado empleado2 = new Empleado(nombresE2.getText().toString(),
                    apellidosE2.getText().toString(),
                    cargoE2.getSelectedItemPosition(),
                    horasEmpleado2
            );

            Empleado empleado3 = new Empleado(nombresE3.getText().toString(),
                    apellidosE3.getText().toString(),
                    cargoE3.getSelectedItemPosition(),
                    horasEmpleado3
            );

            empleados.add(empleado1);
            empleados.add(empleado2);
            empleados.add(empleado3);

            extras.putParcelableArrayList(EXTRA_EMPLEADOS, empleados);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.horas_validacion_texto, Toast.LENGTH_SHORT).show();
        }

    }
}