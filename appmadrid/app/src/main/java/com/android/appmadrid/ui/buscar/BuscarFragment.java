package com.android.appmadrid.ui.buscar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.appmadrid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class BuscarFragment extends Fragment {

    //private BuscarViewModel buscarViewModel;
    ListView listaBusqueda;
    List<Busqueda> busquedaList;
    ImageView estrellaOn;
    ImageView estrellaOff;


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

        //Botón que llama a Dialogo Busqueda
        FloatingActionButton botonBuscar = (FloatingActionButton) view.findViewById(R.id.botonBuscar);
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevaBusqueda nuevaBusqueda=new dialogoNuevaBusqueda();
                nuevaBusqueda.show(getActivity().getSupportFragmentManager(),"Nueva búsqueda");
            }
        });

        //Array de objeto Busqueda
        busquedaList=new ArrayList<>();
        busquedaList.add(new Busqueda("Que bien cuando amanece","Arganzuela", 2020,5,02,true,false));
        busquedaList.add(new Busqueda("Buenos días buenas tardes","Serrano", 2020,6,12,true,true));
        busquedaList.add(new Busqueda("Por fin se acaba","Vallecas", 2020,5,30,false,false));

        final miAdaptadorBusqueda adaptadorBusqueda = new miAdaptadorBusqueda(this.getActivity(),
                R.layout.busqueda_item,
                busquedaList);

        listaBusqueda= (ListView) view.findViewById(R.id.listViewBusqueda);
        listaBusqueda.setAdapter(adaptadorBusqueda);

        //Click en Estrella para cambiarla y (en futuro) acceder a base datos
        listaBusqueda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                estrellaOn=listaBusqueda.getChildAt(position).findViewById(R.id.imageView_favoritoOn);
                estrellaOn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        busquedaList.get(position).setFavorito(false);
                        adaptadorBusqueda.notifyDataSetChanged();
                    }
                });

                estrellaOff=listaBusqueda.getChildAt(position).findViewById(R.id.imageView_favoritoOff);
                estrellaOff.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        busquedaList.get(position).setFavorito(true);
                        adaptadorBusqueda.notifyDataSetChanged();
                    }
                });
            }
        });

        return view;
    }
}
