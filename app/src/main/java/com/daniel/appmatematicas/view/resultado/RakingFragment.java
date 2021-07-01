package com.daniel.appmatematicas.view.resultado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daniel.appmatematicas.R;
import com.daniel.appmatematicas.rest.ReporteApiService;
import com.daniel.appmatematicas.rest.ReporteRequest;
import com.daniel.appmatematicas.util.Constante;
import com.daniel.appmatematicas.util.CuentosViewHolder;
import com.daniel.appmatematicas.util.Reporte;
import com.daniel.appmatematicas.util.Usuario;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RakingFragment extends Fragment {

    private RecyclerView mRecyclerPrincipal;
    private DatabaseReference mDatabase;
    public RakingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_raking, container, false);

        initRecicler(root);

       list(root);

        return root;
    }

    private void list(View root) {
        String ipConfig = Constante.ip_config_;

        ReporteApiService reporteApiService;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ipConfig)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        reporteApiService = retrofit.create(ReporteApiService.class);

        Call<List<Reporte>> call = reporteApiService.getMovie();

        call.enqueue(new Callback<List<Reporte>>() {
            @Override
            public void onResponse(Call<List<Reporte>> call, Response<List<Reporte>> response) {
                List<Reporte> myList = response.body();
                showResponse(myList.toString());
                System.out.println("ca: "+response.body());
                System.out.println("ca: "+response.body());

            }

            @Override
            public void onFailure(Call<List<Reporte>> call, Throwable t) {
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());
            }


        });
    }

    public void showResponse(String response) {
       //Toast.makeText(getActivity(),""+response,Toast.LENGTH_LONG).show();
    }
    private void initRecicler(View root) {
        mRecyclerPrincipal = root.findViewById(R.id.resultados_recycler);
        mRecyclerPrincipal.setHasFixedSize(true);

        mRecyclerPrincipal.setLayoutManager(new GridLayoutManager(getActivity(),
                1, LinearLayoutManager.VERTICAL, false));

        mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        mDatabase.keepSynced(true);
        FirebaseRecyclerAdapter<Usuario, CuentosViewHolder> firebaseRecyclerAdapterPrincipal =
                new FirebaseRecyclerAdapter<Usuario, CuentosViewHolder>(
                        Usuario.class,
                        R.layout.album_card,
                        CuentosViewHolder.class,
                        mDatabase

                ) {
                    @Override
                    protected void populateViewHolder(final CuentosViewHolder viewHolder, Usuario model, final int position) {
                        final String post_key = getRef(position).getKey();
                        viewHolder.setNombre("Usuario: "+ model.getNombre());
                        viewHolder.setNota("Resultado: " + model.getNota());
                        viewHolder.setHora(model.getFecha());

                        viewHolder.mViewStructure.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // viewDetails(post_key,model.getTitulo(),model.getImagen(),model.getDescripcion());
                            }
                        });

                    }
                };

        mRecyclerPrincipal.setAdapter(firebaseRecyclerAdapterPrincipal);

    }

}