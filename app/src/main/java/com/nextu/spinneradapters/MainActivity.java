package com.nextu.spinneradapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.nextu.spinneradapters.adapter.HorarioSpinnerAdapter;
import com.nextu.spinneradapters.modelo.DiaHorario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<DiaHorario> listaElementos;
    private TextView opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.horario_de_clases, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final String[] titulos = getResources().getStringArray(R.array.horario_de_clases);
        String[] subtitulos = getResources().getStringArray(R.array.dias_semana);
        listaElementos = new ArrayList<>();

        for (int i=0; i<titulos.length; i++){
            listaElementos.add(new DiaHorario(titulos[i],subtitulos[i]));
        }

        HorarioSpinnerAdapter adapter = new HorarioSpinnerAdapter(this, listaElementos);

        opcion = (TextView) findViewById(R.id.opcion);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                opcion.setText("Opcion: "+titulos[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                opcion.setText("Opcion: ");
            }
        });
    }
}
