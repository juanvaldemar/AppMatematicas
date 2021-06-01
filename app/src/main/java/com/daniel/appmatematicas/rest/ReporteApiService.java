package com.daniel.appmatematicas.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReporteApiService {

    @GET("api/v1/reporte/")
    Call<List<ReporteResponse>> getMovie();


    @POST("/api/v1/reporte/")
    Call<ReporteRequest> saveNota(@Body ReporteRequest request);


    @POST("/api/v1/usuario/")
    Call<UsuarioRequest> saveNota(@Body UsuarioRequest request);

}
