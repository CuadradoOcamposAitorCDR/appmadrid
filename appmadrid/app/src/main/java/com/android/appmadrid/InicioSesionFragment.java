package com.android.appmadrid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class InicioSesionFragment extends Fragment {
    private TextView fragment_principal;
    private Button fragment_app;
    private ConexionFragmentsInicio mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        fragment_principal = (TextView) view.findViewById(R.id.textView_cancelar_inicio);
        fragment_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentPrincipal = new PrincipalInicioRegistro();
                mListener.moveToFragment(fragmentPrincipal);
            }
        });;
        fragment_app= (Button) view.findViewById(R.id.button_inicio);
        fragment_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), AplicacionActivity.class);
                startActivity(intent);
            }
        });;
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ConexionFragmentsInicio) {
            mListener = (ConexionFragmentsInicio) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " hay que implementar el ConexionFragmentsInicio");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
