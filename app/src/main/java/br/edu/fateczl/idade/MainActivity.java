/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.idade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    private EditText etDia;
    private EditText etMes;
    private EditText etAno;
    private TextView tvIdade;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDia = findViewById(R.id.etDia);
        etDia.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etMes = findViewById(R.id.etMes);
        etMes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etAno = findViewById(R.id.etAno);
        etAno.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvIdade = findViewById(R.id.tvIdade);
        tvIdade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calcularIdade());
    }

    private void calcularIdade() {
        int dia = Integer.parseInt(etDia.getText().toString());
        int mes = Integer.parseInt(etMes.getText().toString());
        int ano = Integer.parseInt(etAno.getText().toString());

        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);


        long totalDias = ChronoUnit.DAYS.between(dataNascimento, dataAtual);
        LocalDate ajusteData = dataNascimento.plusYears(idade.getYears()).plusMonths(idade.getMonths());
        long diasRestantes = ChronoUnit.DAYS.between(ajusteData, dataAtual);

        String resultado = idade.getYears() + " ano(s), " + idade.getMonths() + " mes(es), " + diasRestantes + " dia(s)";
        tvIdade.setText(resultado);
    }
}
