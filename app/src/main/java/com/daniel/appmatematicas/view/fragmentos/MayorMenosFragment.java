package com.daniel.appmatematicas.view.fragmentos;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daniel.appmatematicas.R;
import com.daniel.appmatematicas.rest.ReporteRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class MayorMenosFragment extends Fragment {
    private SharedPreferences prefs = null;

    private Button validar;

    private int numeroAleatorioPrincipal;
    private int valorSeleccionado;
    private boolean seleccion;

    private RelativeLayout mPrimeroR;
    private RelativeLayout mSegundoR;
    private RelativeLayout mTerceroR;
    private RelativeLayout mCuartoR;
    private RelativeLayout mQuintoR;
    private RelativeLayout mSextoR;

    private TextView mPrimero;
    private TextView mSegundo;
    private TextView mTercero;
    private TextView mCuarto;
    private TextView mQuinto;
    private TextView mSexto;

    private EditText primero_;
    private EditText segundo_;
    private EditText tercero_;
    private EditText cuarto_;
    private EditText quinto_;
    private EditText sexto_;


    public MayorMenosFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_mayor_menos, container, false);


        primero_ = root.findViewById(R.id.primero_);
        segundo_ = root.findViewById(R.id.segundo_);
        tercero_ = root.findViewById(R.id.tercero_);
        cuarto_ = root.findViewById(R.id.cuarto_);
        quinto_ = root.findViewById(R.id.quinto_);
        sexto_ = root.findViewById(R.id.sexto_);
        prefs = getActivity().getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);


        initTemas(root);

        ImageView btnCerrar;
        btnCerrar = root.findViewById(R.id.cerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_home);
            }
        });
        return root;
    }

    private void initTemas(View root) {
        initGenerados(root);

    }

    private void initGenerados(View root) {
        initSeleccionEmpty(root);

        initClicks(root);

    }
    private void initSeleccionEmpty(View root) {

        mPrimeroR = root.findViewById(R.id.seleccion_primero);
        mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mSegundoR= root.findViewById(R.id.seleccion_segundo);
        mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));



        mTerceroR= root.findViewById(R.id.seleccion_tercero);
        mTerceroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mCuartoR = root.findViewById(R.id.seleccion_cuarto);

        mCuartoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mQuintoR = root.findViewById(R.id.seleccion_quinto);

        mQuintoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        mSextoR = root.findViewById(R.id.seleccion_sexto);

        mSextoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

    }
    private void initClicks(View root) {

        mPrimeroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt(mPrimero.getText().toString());
                seleccion = true;
                mPrimeroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mSegundoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt(mSegundo.getText().toString());
                seleccion = true;
                mSegundoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mTerceroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt(mTercero.getText().toString());
                seleccion = true;
                mTerceroR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mCuartoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt(mCuarto.getText().toString());
                seleccion = true;
                mCuartoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });
        mQuintoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty(root);
                valorSeleccionado = Integer.parseInt(mQuinto.getText().toString());
                seleccion = true;
                mQuintoR.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

            }
        });

        Button validar = root.findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = primero_.getText().toString();
                String b = segundo_.getText().toString();
                String c =  tercero_.getText().toString();
                String d = cuarto_.getText().toString();
                String e = quinto_.getText().toString();
                String f =  sexto_.getText().toString();
                Boolean validador = false;
                if(a.equalsIgnoreCase("87")){
                    if(b.equalsIgnoreCase("65")){
                        if(c.equalsIgnoreCase("50")){
                            if(d.equalsIgnoreCase("41")){
                                if(e.equalsIgnoreCase("40")){
                                    if(f.equalsIgnoreCase("29")){
                                        validador = true;
                                    }
                                }
                            }
                        }
                    }
                }
                showSnackBar("validador"+validador);
                if(validador){
                    prefs.edit().putString("modulo_5", "1").commit();
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_o);
                }else{
                    prefs.edit().putString("modulo_5", "0").commit();
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_o);
                }


            }

        });

    }
    public void showSnackBar(String msg) {
        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
    }

}