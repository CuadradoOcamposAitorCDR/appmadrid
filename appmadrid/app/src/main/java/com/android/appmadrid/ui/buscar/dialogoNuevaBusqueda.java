package com.android.appmadrid.ui.buscar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.appmadrid.ConexionFragmentsInicio;
import com.android.appmadrid.R;

public class dialogoNuevaBusqueda extends DialogFragment {
    AlertDialog.Builder builder;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View dialogview=inflater.inflate(R.layout.dialogo_nueva_busqueda, null);
        builder.setView(dialogview);

        builder.setTitle("Búsqueda")
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Búsqueda realizada", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });


        //Spinner
        Spinner spinnerGratuito=(Spinner) dialogview.findViewById(R.id.spinner_busquedaGratutito);
        ArrayAdapter<CharSequence> adapterGratuito=ArrayAdapter.createFromResource(this.getActivity(),R.array.gratuito_array, R.layout.support_simple_spinner_dropdown_item);
        adapterGratuito.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerGratuito.setAdapter(adapterGratuito);

        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            /*mListener = (OnNuevaAveriaListener) context;*/
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
