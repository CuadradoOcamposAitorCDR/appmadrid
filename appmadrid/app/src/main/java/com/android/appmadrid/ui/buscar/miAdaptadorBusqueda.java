package com.android.appmadrid.ui.buscar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.appmadrid.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class miAdaptadorBusqueda extends ArrayAdapter<Busqueda> {
    Context ctx;
    int layoutTemplate;
    List<Busqueda> busquedaList;

    public miAdaptadorBusqueda(@NonNull Context context, int resource, @NonNull List<Busqueda> objects) {
        super(context, resource, objects);
        this.ctx=context;
        this.layoutTemplate=resource;
        this.busquedaList=objects;
    }

    @NonNull
    @Override
    //Se lanza automáticamente como si fuera un bucle por cada elemento que se reciba en objects
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        //Obtener la información del elemento de la lista que estoy iteranto en el momento
        Busqueda elementoActual=busquedaList.get(position);

        //Rescatar los elementos de la IU (interfaz usuario) de la plantilla
        TextView textViewTitulo=v.findViewById(R.id.textView_tituloBusqueda);
        TextView textViewDistrito=v.findViewById(R.id.textView_distritoBusqueda);
        TextView textViewFecha=v.findViewById(R.id.textView_fechaBusqueda);
        TextView textViewPrecio=v.findViewById(R.id.textView_precioBusqueda);
        ImageView imageViewFavoritoOff=v.findViewById(R.id.imageView_favoritoOff);
        ImageView imageViewFavoritoOn=v.findViewById(R.id.imageView_favoritoOn);

        //Hacer un set de la info del elemento Actual en los elementos de la IU
        textViewTitulo.setText(elementoActual.getTitulo());
        textViewDistrito.setText(elementoActual.getDistrito());

        Date fecha=elementoActual.getFechaInicio();
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicio=dateFormat.format(fecha);
        textViewFecha.setText(fechaInicio);

        if(elementoActual.isGratuito()){
            textViewPrecio.setText("Gratuito");
        }else{
            textViewPrecio.setText("De pago");
        }

        if(elementoActual.isFavorito()){
            imageViewFavoritoOn.setVisibility(View.VISIBLE);
            imageViewFavoritoOff.setVisibility(View.INVISIBLE);
        }else{
            imageViewFavoritoOff.setVisibility(View.VISIBLE);
            imageViewFavoritoOn.setVisibility(View.INVISIBLE);
        }
        return v;
    }
}
