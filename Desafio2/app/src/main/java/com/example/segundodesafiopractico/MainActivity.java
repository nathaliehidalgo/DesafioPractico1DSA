package com.example.segundodesafiopractico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView candidato_1, candidato_2, candidato_3, candidato_4;
    Button calculate_button;
    EditText votos;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candidato_1 = findViewById(R.id.resultado_candidato1);
        candidato_2 = findViewById(R.id.resultado_candidato2);
        candidato_3 = findViewById(R.id.resultado_candidato3);
        candidato_4 = findViewById(R.id.resultado_candidato4);
        calculate_button = findViewById(R.id.calculate_button);
        votos = findViewById(R.id.votos);

        calculate_button.setOnClickListener(v -> {
            String votos_trimmed = votos.getText().toString().replaceAll("\\s+", "");
            String[] votos_array = votos_trimmed.split(",");

            int counterCandidato1 = 0;
            int counterCandidato2 = 0;
            int counterCandidato3 = 0;
            int counterCandidato4 = 0;

            for (String voto : votos_array) {
                if ("1".equals(voto)) {
                    counterCandidato1++;
                } else if ("2".equals(voto)) {
                    counterCandidato2++;
                } else if ("3".equals(voto)) {
                    counterCandidato3++;
                } else if ("4".equals(voto)) {
                    counterCandidato4++;
                }
            }

            candidato_1.setText(String.format("Candidato 1 -> Votos: %d  Porcentaje: %.2f%%", counterCandidato1, ((double)counterCandidato1 / votos_array.length) * 100));
            candidato_2.setText(String.format("Candidato 2 -> Votos: %d  Porcentaje: %.2f%%", counterCandidato2, ((double)counterCandidato2 / votos_array.length) * 100));
            candidato_3.setText(String.format("Candidato 3 -> Votos: %d  Porcentaje: %.2f%%", counterCandidato3, ((double)counterCandidato3 / votos_array.length) * 100));
            candidato_4.setText(String.format("Candidato 4 -> Votos: %d  Porcentaje: %.2f%%", counterCandidato4, ((double)counterCandidato4 / votos_array.length) * 100));

            candidato_1.setVisibility(View.VISIBLE);
            candidato_2.setVisibility(View.VISIBLE);
            candidato_3.setVisibility(View.VISIBLE);
            candidato_4.setVisibility(View.VISIBLE);

        });
    }

}