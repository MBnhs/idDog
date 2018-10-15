package br.com.marcelo.iddog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.marcelo.iddog.imagem.ImagemActivity;
import br.com.marcelo.iddog.login.LoginContract;
import br.com.marcelo.iddog.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.View{

    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new LoginPresenter(this, this);

        Button button = findViewById(R.id.button_cadastro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.realizaLogin("your@email.com");
            }
        });

    }


    @Override
    public void loginRealizado() {
        Intent fotos = new Intent(MainActivity.this, ImagemActivity.class);
        startActivity(fotos);
    }
}
