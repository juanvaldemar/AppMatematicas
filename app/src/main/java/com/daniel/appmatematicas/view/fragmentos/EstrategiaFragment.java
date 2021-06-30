package com.daniel.appmatematicas.view.fragmentos;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.daniel.appmatematicas.R;

import static android.content.Context.MODE_PRIVATE;


public class EstrategiaFragment extends Fragment {
    private SharedPreferences prefs = null;
    private String resultadoList;
    private Button validar;
    private EditText resultado;

    public EstrategiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_estrategia, container, false);
        prefs = getActivity().getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);
        resultadoList = prefs.getString("modulo_3","");
        ImageView btnCerrar;
        btnCerrar = root.findViewById(R.id.cerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_home);
            }
        });

        validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultado3);
            }
        });
        resultado = root.findViewById(R.id.resultado);
        init();
        return root;
    }

    private void init() {
        String resultado_= resultado.getText().toString();

        if(resultado_.equalsIgnoreCase("96")){
            prefs.edit().putString("modulo_3", resultadoList+",1").commit();
        }else{
            prefs.edit().putString("modulo_3", resultadoList+",0").commit();
        }
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultado3);




    }
}