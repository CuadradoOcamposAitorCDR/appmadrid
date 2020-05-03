package com.android.appmadrid.ui.inicio;


import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.appmadrid.AplicacionActivity;
import com.android.appmadrid.Modelo;
import com.android.appmadrid.R;
import com.android.appmadrid.Usuario;
import com.android.appmadrid.ui.buscar.Evento;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InicioFragment extends Fragment {

   // private InicioViewModel inicioViewModel;
    ListView listaFavoritos;
    List<Evento> favoritosList;
    private ImageView calendario;
    private ImageView eliminar;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        /*Cosas de ViewModel
        inicioViewModel =
                ViewModelProviders.of(this).get(InicioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        inicioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/


        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        final Modelo modelo= Modelo.getModelo(getActivity());
        Usuario user=Usuario.construirUsuario();
        final String idUser=user.getIdUsuario();

        favoritosList=new ArrayList<>();
        favoritosList=modelo.buscarEventosFavoritos(idUser);

        final miAdaptadorFavoritos adaptadorFavoritos = new miAdaptadorFavoritos(this.getActivity(),
                R.layout.favorito_item,
                favoritosList);

        listaFavoritos= (ListView) view.findViewById(R.id.listViewFavoritos);
        listaFavoritos.setAdapter(adaptadorFavoritos);


        return view;
    }
}
