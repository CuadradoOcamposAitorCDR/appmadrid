package com.android.appmadrid.ui.buscar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.appmadrid.Modelo;
import com.android.appmadrid.R;
import com.android.appmadrid.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

public class BuscarFragment extends Fragment {

    //private BuscarViewModel buscarViewModel;
    ListView listaBusqueda;
    List<Evento> eventoList;


    public View onCreateView(@NonNull LayoutInflater inflater,
           ViewGroup container, Bundle savedInstanceState) {
        /* Cosas del ViewModel
        buscarViewModel =
                ViewModelProviders.of(this).get(BuscarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_buscar, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        buscarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        final Modelo modelo= Modelo.getModelo(getActivity());
        Usuario user=Usuario.construirUsuario();
        final String idUser=user.getIdUsuario();

        //Botón que llama a Dialogo Evento
        FloatingActionButton botonBuscar = (FloatingActionButton) view.findViewById(R.id.botonBuscar);
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevaBusqueda nuevaBusqueda=new dialogoNuevaBusqueda();
                nuevaBusqueda.show(getActivity().getSupportFragmentManager(),"Nueva búsqueda");
            }
        });

        //Array de objeto Evento
        eventoList =new ArrayList<>();
        eventoList=modelo.buscarEventos();

        final miAdaptadorBusqueda adaptadorBusqueda = new miAdaptadorBusqueda(this.getActivity(),
                R.layout.busqueda_item,
                eventoList);

        listaBusqueda= (ListView) view.findViewById(R.id.listViewBusqueda1);
        listaBusqueda.setAdapter(adaptadorBusqueda);
        adaptadorBusqueda.notifyDataSetChanged();


        return view;
    }


}
