package br.com.marcelo.iddog.imagem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.iddog.R;

public class ImagemActivity extends AppCompatActivity implements ImagemContract.View {

    private ImagemContract.Presenter presenter;
    private ImagensAdapter adapter;
    private List<String> imagensCarregadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagem);
        imagensCarregadas = new ArrayList<>();
        presenter = new ImagemPresenter(this, this);
        presenter.carregaImagens();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.husky:
                presenter.carregaImagens("husky");
                return true;
            case R.id.pug:
                presenter.carregaImagens("pug");
                return true;
            case R.id.labrador:
                presenter.carregaImagens("labrador");
                return true;
            case R.id.hound:
                presenter.carregaImagens("hound");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void mostraImagens(final List<String> imagens) {
        imagensCarregadas = imagens;
        adapter = new ImagensAdapter(this, imagensCarregadas, new OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                ImageView imageView = findViewById(R.id.imagem_extendida_imageview);
                Picasso.get().load(item).into(imageView);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.imagens_recyclerview);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void atualizaListaDeImagens(List<String> imagens) {
        imagensCarregadas.clear();
        imagensCarregadas.addAll(imagens);
        adapter.notifyDataSetChanged();
    }


}
