package com.daniel.appmatematicas.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.appmatematicas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculadoraIIFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculadoraIIFragment extends Fragment {


    public CalculadoraIIFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculadora_i_i, container, false);



        return root;
    }
}