package com.nextu.spinneradapters.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nextu.spinneradapters.R;
import com.nextu.spinneradapters.modelo.DiaHorario;

import java.util.List;

/**
 * Created by Next University.
 */
public class HorarioSpinnerAdapter extends ArrayAdapter<DiaHorario> {
    public HorarioSpinnerAdapter(Context context, List<DiaHorario> objects) {
        super(context, R.layout.spinner_template, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View elemento = inflater.inflate(R.layout.spinner_template, null);

        TextView titulo = (TextView) elemento.findViewById(R.id.titulo);
        TextView subtitulo = (TextView) elemento.findViewById(R.id.subtitulo);

        titulo.setText(getItem(position).getAsignatura());
        subtitulo.setText(getItem(position).getDia());

        return elemento;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View elemento = inflater.inflate(R.layout.spinner_template, null);

        TextView titulo = (TextView) elemento.findViewById(R.id.titulo);
        TextView subtitulo = (TextView) elemento.findViewById(R.id.subtitulo);

        titulo.setText(getItem(position).getAsignatura());
        subtitulo.setText(getItem(position).getDia());

        return elemento;
    }
}
