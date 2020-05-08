package com.android.appmadrid.ui.cuenta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.appmadrid.Modelo;
import com.android.appmadrid.R;
import com.android.appmadrid.Usuario;

public class CuentaFragment extends Fragment {

    TextView cambioUsuario;
    TextView cambioPassword;
    TextView cambioMail;
    TextView nombreUsuario;
    TextView mailUsuario;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
       /* cuentaViewModel =
                ViewModelProviders.of(this).get(CuentaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cuenta, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        cuentaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
        View view = inflater.inflate(R.layout.fragment_cuenta, container, false);
        Modelo modelo=Modelo.getModelo(getActivity());
        Usuario user= Usuario.construirUsuario();
        String userId=user.getIdUsuario();

        nombreUsuario=(TextView) view.findViewById(R.id.textView_nombreUsuarioCuenta);
        nombreUsuario.setText(modelo.getNombreUsuario(userId));

        mailUsuario=(TextView) view.findViewById(R.id.textView_tuMailCuenta);
        mailUsuario.setText(modelo.getMailUsuario(userId));

        cambioUsuario= (TextView) view.findViewById(R.id.textView_cambioUsuario);
        cambioPassword= (TextView) view.findViewById(R.id.textView_cambioPassword);
        cambioMail= (TextView) view.findViewById(R.id.textView_cambioMail);

        cambioUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoCambioUsuario cambioUsuario= new dialogoCambioUsuario();
                cambioUsuario.show(getActivity().getSupportFragmentManager(),"Cambio de usuario");
            }
        });

        cambioPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoCambioPassword cambioPassword= new dialogoCambioPassword();
                cambioPassword.show(getActivity().getSupportFragmentManager(),"Cambio de constraseña");
            }
        });

        cambioMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoCambioMail cambioMail= new dialogoCambioMail();
                cambioMail.show(getActivity().getSupportFragmentManager(),"Cambio de mail");
            }
        });

        return view;
    }
}
