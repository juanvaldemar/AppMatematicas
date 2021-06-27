package com.daniel.appmatematicas.view.resultado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daniel.appmatematicas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    private TextView modulo1;
    private TextView modulo2;
    private TextView modulo3;
    private TextView modulo4;
    private TextView modulo5;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        initView(root);


        return root;
    }

    private void initView(View root) {
        modulo1 = root.findViewById(R.id.modulo1);
        modulo2 = root.findViewById(R.id.modulo2);
        modulo3 = root.findViewById(R.id.modulo3);
        modulo4 = root.findViewById(R.id.modulo4);
        modulo5 = root.findViewById(R.id.modulo4);

        modulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_modulo_i);
            }
        });

        modulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_modulo_i_i);
            }
        });

        modulo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_modulo_i_i_i);
            }
        });

        modulo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_modulo_i_v);
            }
        });

        modulo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultadoV);
            }
        });

    }
}