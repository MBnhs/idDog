package br.com.marcelo.iddog.imagem;

import java.util.List;

public interface ImagemContract {

    interface View {
        void mostraImagens(List<String> imagens);
        void atualizaListaDeImagens(List<String> imagens);
    }

    interface Presenter {
        void carregaImagens();
        void carregaImagens(String categoria);
    }
}
