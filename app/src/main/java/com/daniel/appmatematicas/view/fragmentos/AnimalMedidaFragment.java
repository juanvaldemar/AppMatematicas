package com.daniel.appmatematicas.view.fragmentos;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daniel.appmatematicas.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AnimalMedidaFragment extends Fragment {

    private int numeroAleatorioPrincipal;
    private int valorSeleccionado;
    private boolean seleccion;

    private RelativeLayout mPrimeroR;
    private RelativeLayout mSegundoR;
    private RelativeLayout mTerceroR;


    private TextView mPrimero;
    private TextView mSegundo;
    private TextView mTercero;


    public AnimalMedidaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_animal_medida, container, false);
          initGenerados(root);
        return root;
    }


    private void initGenerados(View root) {
        Random rd = new Random();
        List<Integer> generados = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int aleatorio = 0;
            boolean generado = false;
            while (!generado) {
                int posible = rd.nextInt(100);
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    aleatorio = posible;
                    generado = true;
                }
            }
            if (i == 6) {
                initFonts(generados, 15,root);
            }
            System.out.println("Aleatorio: " + aleatorio);
        }
        initSeleccionEmpty(root);

        initClicks(root);


    }
    private void initFonts(List<Integer> generados, int principal, View root) {


        numeroAleatorioPrincipal = principal;

        mPrimero = root.findViewById(R.id.primero);
        mSegundo = root.findViewById(R.id.segundo);
        mTercero = root.findViewById(R.id.tercero);



        mPrimero.setText("A");
        mSegundo.setText("B");
        mTercero.setText("C");

        //encuentra_numero_text = findViewById(R.id.encuentra_numero_text);
        //encuentra_numero_text.setText("Encuentra el número "+ this.numeroAleatorioPrincipal +":");
    }


    private void initSeleccionEmpty(View root) {

        mPrimeroR = root.findViewById(R.id.seleccion_primero);
        mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mSegundoR= root.findViewById(R.id.seleccion_segundo);
        mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mTerceroR= root.findViewById(R.id.seleccion_tercero);
        mTerceroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));




    }

    private void initClicks(View root) {

        mPrimeroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt("1");
                seleccion = true;
                mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mSegundoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt("2");
                seleccion = true;
                mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mTerceroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt("5");
                seleccion = true;
                mTerceroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });


        Button validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccion){
                    //Toast.makeText(BuscarNumeroActivity.this,"Por favor seleccione una opcción.",Toast.LENGTH_LONG).show();
                    showSnackBar("¡Por favor seleccione una opcción valida!");
                }else{
                    if(valorSeleccionado == numeroAleatorioPrincipal){
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

                   /* contador = findViewById(R.id.contador);
                    int contador_ = Integer.parseInt(contador.getText().toString());

                    iniciarNuevamente();
                    int contador2 = contador_+1;
                    if(contador2 > 9){
                        prefs.edit().putString("prefs_puntaje", listaCalificacion.toString()).commit();
                        showSnackBar(listaCalificacion.toString());
                        startActivity(new Intent(BuscarNumeroActivity.this, ResultadoFinal.class));
                        finish();
                    }
                    contador.setText(contador2+ "");

                    */
                }
            }
        });

    }

    public void showSnackBar(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }
}