package com.android.appmadrid.ui.buscar;

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

public class BuscarFragment extends Fragment {

    private BuscarViewModel buscarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
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
        return root;
    }
}
