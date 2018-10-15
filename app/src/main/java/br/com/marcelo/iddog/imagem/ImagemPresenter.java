package br.com.marcelo.iddog.imagem;

import android.content.Context;
import android.util.Log;

import br.com.marcelo.iddog.data.RetrofitInicializador;
import br.com.marcelo.iddog.data.SharedPreferencesTokenRepository;
import br.com.marcelo.iddog.data.TokenRepository;
import br.com.marcelo.iddog.model.cachorro.CachorroResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagemPresenter implements ImagemContract.Presenter {

    private TokenRepository tokenRepository;
    private ImagemContract.View view;

    public ImagemPresenter(Context context, ImagemContract.View view) {
        tokenRepository = new SharedPreferencesTokenRepository(context);
        this.view = view;
    }

    @Override
    public void carregaImagens() {
        String token = tokenRepository.get("token");
        Call<CachorroResponse> getCall = new RetrofitInicializador().getCachorroService().get(token);
        getCall.enqueue(new Callback<CachorroResponse>() {
            @Override
            public void onResponse(Call<CachorroResponse> call, Response<CachorroResponse> response) {
                view.mostraImagens(response.body().getList());
            }

            @Override
            public void onFailure(Call<CachorroResponse> call, Throwable t) {
                Log.e("Deu ruim", t.getMessage());
            }
        });
    }

    @Override
    public void carregaImagens(String categoria) {
        String token = tokenRepository.get("token");
        Call<CachorroResponse> getCall = new RetrofitInicializador().getCachorroService().get(token, categoria);
        getCall.enqueue(new Callback<CachorroResponse>() {
            @Override
            public void onResponse(Call<CachorroResponse> call, Response<CachorroResponse> response) {
                view.atualizaListaDeImagens(response.body().getList());
            }

            @Override
            public void onFailure(Call<CachorroResponse> call, Throwable t) {
                Log.e("Deu ruim", t.getMessage());
            }
        });

    }
}
