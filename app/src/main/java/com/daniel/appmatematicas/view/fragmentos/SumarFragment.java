package com.daniel.appmatematicas.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.appmatematicas.R;

public class SumarFragment extends Fragment {


        private EditText mPrimero;
        private EditText mSegundo;
        private int valorUno;
        private int valorDos;



        public SumarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.suma, container, false);

        mPrimero = root.findViewById(R.id.primero);
        mSegundo = root.findViewById(R.id.segundo);
        valorDos = 0;
        valorDos = 0;

        Button validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorUno = Integer.parseInt(mPrimero.getText().toString());
                valorDos = Integer.parseInt(mSegundo.getText().toString());
                if(valorUno != 0){

                    if(valorUno != 0){
                        if(valorUno == 5 && valorDos == 5){
                            //Toast.makeText(BuscarNumeroActivity.this,"Seleccionó "+valorSeleccionado,Toast.LENGTH_SHORT).show();
                            showSnackBar("¡Muy bien!");
                            //startActivity(new Intent(getActivity(), PerfilActivity.class));
                            // listaCalificacion.add(true);
                        }else{
                            //Toast.makeText(BuscarNumeroActivity.this,"Incorrecto "+valorSeleccionado,Toast.LENGTH_SHORT).show();
                            showSnackBar("¡Oh no fallaste!");
                            //listaCalificacion.add(false);
                            // startActivity(new Intent(getActivity(), PerfilActivity.class));
                        }
                    }else{
                        showSnackBar("Escriba una respuesta válida");
                    }
                }else {
                    showSnackBar("Escriba una respuesta válida");
                }


            }
        });


        return root;
    }

    public void showSnackBar(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }
}