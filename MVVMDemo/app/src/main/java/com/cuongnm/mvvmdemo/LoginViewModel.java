package com.cuongnm.mvvmdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isMessageVisible = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onLickLogin(){
        User user = new User(email, password);
        if(user.isValidEmail() && user.isValidUser()){
            messageLogin.set("Login success");
        }else{
            messageLogin.set("Email or password invalid");
        }
        isMessageVisible.set(true);
    }
}
