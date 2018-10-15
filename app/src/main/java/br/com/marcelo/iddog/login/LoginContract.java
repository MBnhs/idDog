package br.com.marcelo.iddog.login;

public interface LoginContract {

    interface View {
        void loginRealizado();
    }

    interface Presenter {
        void realizaLogin(String email);
    }

}
