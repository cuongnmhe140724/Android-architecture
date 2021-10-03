package com.cuongnm.mvpdemo;

public class LoginPresenter {

    private ILogin iLogin;

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public void login(String email, String password){

        User user = new User(email, password);

        if(user.isValidEmail() && user.isValidUser()){
            iLogin.loginSuccess();
        }else{
            iLogin.loginFail(); 
        }
    }

}
