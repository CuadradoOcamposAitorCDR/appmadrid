package com.android.appmadrid.ui.buscar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.appmadrid.AplicacionActivity;
import com.android.appmadrid.ConexionFragmentsInicio;
import com.android.appmadrid.Modelo;
import com.android.appmadrid.R;
import com.android.appmadrid.Usuario;

import java.util.ArrayList;
import java.util.List;

public class dialogoNuevaBusqueda extends DialogFragment {
    AlertDialog.Builder builder;
    Modelo modelo=Modelo.getModelo(getActivity());
    private EditText busquedaTitulo;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        final LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View dialogview=inflater.inflate(R.layout.dialogo_nueva_busqueda, null);
        builder.setView(dialogview);

        builder.setTitle("Búsqueda")
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        busquedaTitulo= (EditText) dialogview.findViewById(R.id.editText_busquedaTitulo);
                        String titulo= busquedaTitulo.getText().toString();
                        /*List<Evento> hola= new ArrayList<>();
                        hola=modelo.buscarEventos(titulo);*/
                        Intent i= new Intent();
                        //i.putExtra("sdf",hola);
                        //Toast.makeText(getActivity(), "Texto "+ hola.size(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

    dialogoNuevaBusqueda listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            //listener=(dialogoNuevaBusqueda) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
