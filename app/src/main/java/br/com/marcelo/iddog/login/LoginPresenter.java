package br.com.marcelo.iddog.login;

import android.content.Context;
import android.util.Log;

import br.com.marcelo.iddog.MainActivity;
import br.com.marcelo.iddog.data.RetrofitInicializador;
import br.com.marcelo.iddog.data.SharedPreferencesTokenRepository;
import br.com.marcelo.iddog.data.TokenRepository;
import br.com.marcelo.iddog.model.Usuario;
import br.com.marcelo.iddog.model.cachorro.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private TokenRepository tokenRepository;
    private LoginContract.View view;

    public LoginPresenter(MainActivity context, LoginContract.View view) {
        tokenRepository = new SharedPreferencesTokenRepository(context);
        this.view = view;
    }

    @Override
    public void realizaLogin(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        Call<LoginResponse> cadastraCall = new RetrofitInicializador().getCachorroService().cadastra(usuario);
        cadastraCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token = response.body().getUser().getToken();
                Log.i("token", token);
                tokenRepository.salva(token);
                view.loginRealizado();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("deu ruim", t.getMessage());
            }
        });

    }
}
