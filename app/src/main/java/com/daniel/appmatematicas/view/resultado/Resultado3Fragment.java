package com.daniel.appmatematicas.view.resultado;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.daniel.appmatematicas.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Resultado3Fragment extends Fragment {
    private SharedPreferences prefs = null;
    private String resultadoList;
    private TextView resultado;
    public Resultado3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_resultado, container, false);
        prefs = getActivity().getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);
        resultadoList = prefs.getString("modulo_3","");
        String[] notas = resultadoList.split(",");

        ImageView btnCerrar;

      //  Toast.makeText(getActivity(),"----"+resultadoList,Toast.LENGTH_LONG).show();
        resultado = root.findViewById(R.id.resultado);
        initNota(notas,7);
        btnCerrar = root.findViewById(R.id.cerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_home);
            }
        });

        //Back pressed Logic for fragment
        root.setFocusableInTouchMode(true);
        root.requestFocus();
        root.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {

                        return true;
                    }
                }
                return false;
            }
        });
        return root;
    }

    private String initNota(String[] notas, int cantidad) {
        List<String> buenas = new ArrayList<>();

        for (int i = 0; i < cantidad; i++){
                if(notas[i].equalsIgnoreCase("1")){
                    buenas.add("1");
                }
        }
        resultado.setText(buenas.size()+1+"/"+cantidad);

        prefs.edit().remove("modulo_3").commit();


        return "";
    }
}