package br.com.marcelo.iddog.data;

import br.com.marcelo.iddog.model.Usuario;
import br.com.marcelo.iddog.model.cachorro.CachorroResponse;
import br.com.marcelo.iddog.model.cachorro.LoginResponse;
import br.com.marcelo.iddog.model.cachorro.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CachorroService {

    @POST("signup")
    Call<LoginResponse> cadastra(@Body Usuario usuario);

    @GET("feed")
    Call<CachorroResponse> get(@Header("Authorization") String token);

    @GET("feed")
    Call<CachorroResponse> get(@Header("Authorization") String token, @Query("category") String categoria);

}
