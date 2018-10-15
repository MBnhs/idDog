package br.com.marcelo.iddog.data;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder().baseUrl("https://api-iddog.idwall.co/").addConverterFactory(JacksonConverterFactory
                .create()).build();
    }

    public CachorroService getCachorroService() {
        return retrofit.create(CachorroService.class);
    }
}
