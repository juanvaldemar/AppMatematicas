package com.daniel.appmatematicas.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daniel.appmatematicas.R;


public class EstimacionLibrosFragment extends Fragment {

    private Button validar;
    public EstimacionLibrosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_estimacion_libros, container, false);

        initView(root);


        return root;
    }

    private void initView(View root) {
        validar = root.findViewById(R.id.validar);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_estimacion_estrategia);
            }
        });
    }
}