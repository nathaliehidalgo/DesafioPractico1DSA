package com.example.tercerdesafiopractico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tercerdesafiopractico.modelos.Empleado;
import com.example.tercerdesafiopractico.modelos.Resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_EMPLEADOS = "EXTRA_EMPLEADOS";
    private static DecimalFormat DF = new DecimalFormat("#.##");

    TextView resultadoE1, resultadoE2, resultadoE3, resultadoOtros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultadoE1 = findViewById(R.id.resultado_empleado1);
        resultadoE2 = findViewById(R.id.resultado_empleado2);
        resultadoE3 = findViewById(R.id.resultado_empleado3);
        resultadoOtros = findViewById(R.id.resultado_otros);

        ArrayList<Empleado> empleados = getIntent().getParcelableArrayListExtra(EXTRA_EMPLEADOS);
        Empleado empleado1 = empleados.get(0);
        Empleado empleado2 = empleados.get(1);
        Empleado empleado3 = empleados.get(2);

        boolean sinBono = empleado1.getCargo() == 0 && empleado2.getCargo() == 1 && empleado3.getCargo() == 2;

        Resultado resultado1 = obtenerResultado(empleado1, sinBono);
        Resultado resultado2 = obtenerResultado(empleado2, sinBono);
        Resultado resultado3 = obtenerResultado(empleado3, sinBono);

        ArrayList<Resultado> resultados = new ArrayList<>();
        resultados.add(resultado1);
        resultados.add(resultado2);
        resultados.add(resultado3);

        int salarioArribaDe300 = 0;
        for (Resultado resultado : resultados) {
            if (resultado.getSalarioLiquido() > 300) {
                salarioArribaDe300++;
            }
        }

        Collections.sort(resultados, (r1, r2) -> Double.compare(r1.getSalarioLiquido(), r2.getSalarioLiquido()));

        Empleado menorSalario = resultados.get(0).getEmpleado();
        Empleado mayorSalario = resultados.get(2).getEmpleado();

        resultadoE1.setText("Empleado: " + resultado1.getEmpleado().getNombres() + " " + resultado1.getEmpleado().getApellidos() + "\n" +
                "Salario Base: " + DF.format(resultado1.getSalarioBase()) + "\n" +
                "Descuento de ISSS: " + DF.format(resultado1.getIsss()) + "\n" +
                "Descuento de AFP: " + DF.format(resultado1.getAfp()) + "\n" +
                "Descuento de Renta: " + DF.format(resultado1.getRenta()) + "\n" +
                "Sueldo Liquido: " + DF.format(resultado1.getSalarioLiquido()));

        resultadoE2.setText("Empleado: " + resultado2.getEmpleado().getNombres() + " " + resultado2.getEmpleado().getApellidos() + "\n" +
                "Salario Base: " + DF.format(resultado2.getSalarioBase()) + "\n" +
                "Descuento de ISSS: " + DF.format(resultado2.getIsss()) + "\n" +
                "Descuento de AFP: " + DF.format(resultado2.getAfp()) + "\n" +
                "Descuento de Renta: " + DF.format(resultado2.getRenta()) + "\n" +
                "Sueldo Liquido: " + DF.format(resultado2.getSalarioLiquido()));

        resultadoE3.setText("Empleado: " + resultado3.getEmpleado().getNombres() + " " + resultado3.getEmpleado().getApellidos() + "\n" +
                "Salario Base: " + DF.format(resultado3.getSalarioBase()) + "\n" +
                "Descuento de ISSS: " + DF.format(resultado3.getIsss()) + "\n" +
                "Descuento de AFP: " + DF.format(resultado3.getAfp()) + "\n" +
                "Descuento de Renta: " + DF.format(resultado3.getRenta()) + "\n" +
                "Sueldo Liquido: " + DF.format(resultado3.getSalarioLiquido()));

        resultadoOtros.setText("Empleado con Mayor Salario: " + mayorSalario.getNombres() + " " + mayorSalario.getApellidos() + "\n" +
                "Empleado con Menor Salario: " + menorSalario.getNombres() + " " + menorSalario.getApellidos() + "\n" +
                "Salarios arribas de $300: " + salarioArribaDe300);

    }

    private Resultado obtenerResultado(Empleado empleado, boolean sinBono) {
        boolean tieneHorasExtra = empleado.getHoras() > 160;
        double salarioBase;
        if (tieneHorasExtra) {
            int horasExtra = empleado.getHoras() - 160;
            salarioBase = 160 * 9.75 + (horasExtra * 11.5);
        } else {
            salarioBase = empleado.getHoras() * 9.75;
        }

        double isss = salarioBase * 5.25 / 100;
        double afp = salarioBase * 6.88 / 100;
        double renta = salarioBase * 10 / 100;

        double salarioLiquido = salarioBase - isss - afp - renta;

        if (sinBono) {
            Toast.makeText(this, "NO HAY BONO", Toast.LENGTH_SHORT).show();
        } else {
            switch (empleado.getCargo()) {
                case 0:
                    salarioLiquido = salarioLiquido * 1.10;
                    break;
                case 1:
                    salarioLiquido = salarioLiquido * 1.05;
                    break;
                case 2:
                    salarioLiquido = salarioLiquido * 1.03;
                    break;
                default:
                    salarioLiquido = salarioLiquido * 1.02;
                    break;
            }
        }

        return new Resultado(empleado, salarioBase, isss, afp, renta, salarioLiquido);
    }
}