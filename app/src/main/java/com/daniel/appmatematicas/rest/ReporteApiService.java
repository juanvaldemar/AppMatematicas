package com.daniel.appmatematicas.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReporteApiService {

    @GET("api/v1/reporte/")
    Call<List<Reporte>> getMovie();
}
