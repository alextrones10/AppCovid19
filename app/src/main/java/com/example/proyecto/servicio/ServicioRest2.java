package com.example.proyecto.servicio;

import com.example.proyecto.entidad.Triaje;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ServicioRest2 {

    @GET("triaje")
    public abstract Call<List<Triaje>> listaTriaje();

    @POST("triaje")
    public abstract Call<Triaje> agregaTriaje(@Body Triaje triaje);

    @PUT("triaje")
    public abstract Call<Triaje> actualizaTriaje(@Body Triaje triaje);

    @HTTP(method = "DELETE", path = "triaje", hasBody = true)
    public abstract Call<Triaje> eliminaTriaje(@Body Triaje triaje);

}
