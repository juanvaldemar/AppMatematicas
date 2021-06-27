package com.daniel.appmatematicas.view.resultado;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.daniel.appmatematicas.R;
import com.daniel.appmatematicas.rest.ReporteApiService;
import com.daniel.appmatematicas.util.Constante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


public class Resultado5Fragment extends Fragment {
    private SharedPreferences prefs = null;
    private String resultadoList;
    private TextView resultado;
    public Resultado5Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_resultado, container, false);
        prefs = getActivity().getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);
        resultadoList = prefs.getString("modulo_1","");
        String[] notas = resultadoList.split(",");
        System.out.println(resultadoList);

        ImageView btnCerrar;

        Toast.makeText(getActivity(),"----"+resultadoList,Toast.LENGTH_LONG).show();
        resultado = root.findViewById(R.id.resultado);
        initNota(notas,1);
        btnCerrar = root.findViewById(R.id.cerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_home);
            }
        });

        initConnect(root);
        return root;
    }

    private String initNota(String[] notas, int cantidad) {
        List<String> buenas = new ArrayList<>();

        for (int i = 0; i < cantidad; i++){
                if(notas[i].equalsIgnoreCase("1")){
                    buenas.add("1");
                }
        }
        resultado.setText(0+"/"+17);

        SharedPreferences.Editor editor = getActivity().getSharedPreferences("modulo_3", MODE_PRIVATE).edit();
        editor.clear().apply();


        return "";
    }


    private void initConnect(View root) {

        String ipConfig = Constante.ip_config_;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ipConfig+":8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //reporteApiService = retrofit.create(ReporteApiService.class);

    }

}