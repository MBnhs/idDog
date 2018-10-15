package br.com.marcelo.iddog.data;

public interface TokenRepository {

    void salva(String token);

    String get(String s);
}
