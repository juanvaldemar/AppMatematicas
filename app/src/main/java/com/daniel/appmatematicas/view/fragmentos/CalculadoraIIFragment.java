package com.daniel.appmatematicas.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daniel.appmatematicas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculadoraIIFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculadoraIIFragment extends Fragment {

    private Button validar;
    public CalculadoraIIFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculadora_i_i, container, false);

        validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultado);
            }
        });


        return root;
    }
}