package com.android.appmadrid.ui.cuenta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.android.appmadrid.R;

public class CuentaFragment extends Fragment {

    private CuentaViewModel cuentaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        cuentaViewModel =
                ViewModelProviders.of(this).get(CuentaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cuenta, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        cuentaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
