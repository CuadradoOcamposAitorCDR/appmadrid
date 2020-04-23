package com.android.appmadrid.ui.inicio;


import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.android.appmadrid.R;

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
    List<Favoritos> favoritosList;
    private ImageView calendario;

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

        favoritosList=new ArrayList<>();
        favoritosList.add(new Favoritos("Que bien cuando amanece","Arganzuela", 2020,5,02,true));
        favoritosList.add(new Favoritos("Lo más interesante","Moratalaz", 2020,5,24,false));
        favoritosList.add(new Favoritos("Esto me aburre","Centro", 2020,6,10,true));

        miAdaptadorFavoritos adaptadorFavoritos = new miAdaptadorFavoritos(this.getActivity(),
                R.layout.favorito_item,
                favoritosList);

        listaFavoritos= (ListView) view.findViewById(R.id.listViewFavoritos);
        listaFavoritos.setAdapter(adaptadorFavoritos);

        listaFavoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                calendario=listaFavoritos.getChildAt(position).findViewById(R.id.imageView_calendarioFavorito);
                calendario.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentCalendario = new Intent(Intent.ACTION_INSERT)
                                .setData(CalendarContract.Events.CONTENT_URI)
                                .putExtra(CalendarContract.Events.TITLE,favoritosList.get(position).getTitulo())
                                .putExtra(CalendarContract.Events.EVENT_LOCATION,favoritosList.get(position).getDistrito())
                                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,favoritosList.get(position).getFechaInicio().getTime());
                        startActivity(intentCalendario);
                    }
                });
           }
        });

        return view;
    }


}
