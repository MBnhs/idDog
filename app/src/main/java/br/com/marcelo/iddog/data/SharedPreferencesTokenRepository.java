package br.com.marcelo.iddog.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesTokenRepository implements TokenRepository {

    SharedPreferences detalhesDoUsuario;

    public SharedPreferencesTokenRepository(Context context) {
        detalhesDoUsuario = context.getSharedPreferences("detalhesdousuario", Context.MODE_PRIVATE);

    }

    @Override
    public void salva(String token) {
        SharedPreferences.Editor edit = detalhesDoUsuario.edit();
        edit.putString("token", token);
        edit.apply();
    }

    @Override
    public String get(String key) {
        return detalhesDoUsuario.getString(key, "");
    }
}
