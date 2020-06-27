package com.example.proyecto.servicio;

import com.example.proyecto.entidad.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ServicioRest {

    @GET("usuario")
    public abstract Call<List<Usuario>> listaUsuario();

    @POST("usuario")
    public abstract Call<Usuario> agregaUsuario(@Body Usuario user);

    @PUT("usuario")
    public abstract Call<Usuario> actualizaUsuario(@Body Usuario user);

    @HTTP(method = "DELETE", path = "usuario", hasBody = true)
    public abstract Call<Usuario> eliminaUsuario(@Body Usuario user);


}
