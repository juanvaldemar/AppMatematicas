package com.daniel.appmatematicas.view.fragmentos;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daniel.appmatematicas.R;

import static android.content.Context.MODE_PRIVATE;


public class EstimacionLibrosFragment extends Fragment {

    private Button validar;
    private int valorSeleccionado;
    private boolean seleccion;

    private RelativeLayout mPrimeroR;
    private RelativeLayout mSegundoR;
    private SharedPreferences prefs = null;
    private String resultadoList;


    public EstimacionLibrosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_estimacion_libros, container, false);

        initView(root);
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
        initSeleccionEmpty(root);
        initClicks(root);
        return root;
    }


    private void initSeleccionEmpty(View root) {

        mPrimeroR = root.findViewById(R.id.seleccion_primero);
        mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mSegundoR= root.findViewById(R.id.seleccion_segundo);
        mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));



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

    private void initClicks(View root) {

        mPrimeroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt("30");
                seleccion = true;
                mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                System.out.println("30");
            }
        });
        mSegundoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt("40");
                seleccion = true;
                mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));
                System.out.println("40");

            }
        });

        Button validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccion){
                    //Toast.makeText(BuscarNumeroActivity.this,"Por favor seleccione una opcción.",Toast.LENGTH_LONG).show();
                    showSnackBar("¡Por favor seleccione una opcción valida!");
                    System.out.println("seleccion");

                }else{
                    if(valorSeleccionado < 40){
                        prefs.edit().putString("modulo_3", resultadoList+",1").commit();
                        showSnackBar("resultadoList: "+resultadoList+valorSeleccionado);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultado3);


                    }else {
                        prefs.edit().putString("modulo_3", resultadoList + ",0").commit();
                        showSnackBar("resultadoList: " + resultadoList + valorSeleccionado);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_resultado3);
                    }
                    }
            }
        });

    }


    public void showSnackBar(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }

}