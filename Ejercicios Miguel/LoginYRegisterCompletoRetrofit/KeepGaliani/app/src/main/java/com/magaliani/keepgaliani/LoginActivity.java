package com.magaliani.keepgaliani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by GaloMcTunki on 21/02/2018.
 */

public class LoginActivity extends AppCompatActivity{
    EditText email;
    EditText password;
    Button doLogin;
    Button register;
    private ResponseAuth responseAuth;
    private Call<ResponseAuth> peticionAlLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.inputcorreo);
        password = findViewById(R.id.inputpassword);
        doLogin = findViewById(R.id.buttonDoLogin);
        register = findViewById(R.id.buttonGoRegister);

        doLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ILoginAndRegister iLoginAndRegister = ServiceGenerator.createService(ILoginAndRegister.class);

                peticionAlLogin = iLoginAndRegister.doLogin(email.getText().toString(), password.getText().toString());

                peticionAlLogin.enqueue(new Callback<ResponseAuth>() {
                    @Override
                    public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                        if(response.isSuccessful()){
                            responseAuth = response.body();
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            Log.i("loggin", responseAuth.toString());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseAuth> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}