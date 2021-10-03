package com.cuongnm.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ILogin{

    private EditText et_email;
    private EditText et_password;
    private Button btn_login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        presenter = new LoginPresenter(this);
        
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLogin();
            }
        });
    }

    private void onClickLogin() {
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        presenter.login(email, password);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_LONG);
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login fail", Toast.LENGTH_LONG);
    }
}