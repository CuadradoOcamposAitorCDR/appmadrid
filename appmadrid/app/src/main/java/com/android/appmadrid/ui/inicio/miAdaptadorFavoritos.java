package com.android.appmadrid.ui.inicio;

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
import java.util.Iterator;
import java.util.List;

class miAdaptadorFavoritos extends ArrayAdapter<Favoritos> {
    Context ctx;
    int layoutTemplate;
    List<Favoritos> favoritosList;

    public miAdaptadorFavoritos(@NonNull Context context, int resource, @NonNull List<Favoritos> objects) {
        super(context, resource, objects);
        this.ctx=context;
        this.layoutTemplate=resource;
        this.favoritosList=objects;
    }

    @NonNull
    @Override
    //Se lanza automáticamente como si fuera un bucle por cada elemento que se reciba en objects
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        //Obtener la información del elemento de la lista que estoy iteranto en el momento
        Favoritos elementoActual=favoritosList.get(position);
        /*Iterator itr=favoritosList.iterator();*/

        //Rescatar los elementos de la IU (interfaz usuario) de la plantilla
        TextView textViewTitulo=v.findViewById(R.id.textView_tituloFavorito);
        TextView textViewDistrito=v.findViewById(R.id.textView_distritoFavorito);
        TextView textViewFecha=v.findViewById(R.id.textView_fechaFavorito);
        TextView textViewPrecio=v.findViewById(R.id.textView_precioFavorito);
        ImageView imageViewEliminar=v.findViewById(R.id.imageView_eliminarFavorito);
        ImageView imageViewCalendario=v.findViewById(R.id.imageView_calendarioFavorito);

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

        /*while (itr.hasNext()){
            Favoritos elementoEliminar= (Favoritos) itr.next();
            if(elementoEliminar.isEliminar()) {
                itr.remove();
                break;
            }
        }
       if(elementoActual.isEliminar()){

       }*/
        return v;
    }


}
