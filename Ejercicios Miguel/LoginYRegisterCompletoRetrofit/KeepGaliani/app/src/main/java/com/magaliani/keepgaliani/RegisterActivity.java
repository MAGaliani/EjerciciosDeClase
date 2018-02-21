package com.magaliani.keepgaliani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by GaloMcTunki on 21/02/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText nombre;
    EditText email;
    EditText password;
    Button doRegister;
    Button login;
    private ResponseAuth responseAuth;
    private Call<ResponseAuth> peticionAlRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.inputnombre);
        email = findViewById(R.id.inputcorreo);
        password = findViewById(R.id.inputpassword);
        doRegister = findViewById(R.id.buttonDoRegister);
        login = findViewById(R.id.buttonGoLogin);

        doRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ILoginAndRegister iLoginAndRegister = ServiceGenerator.createService(ILoginAndRegister.class);

                peticionAlRegister = iLoginAndRegister.doRegistro(nombre.getText().toString(), email.getText().toString(), password.getText().toString());

                peticionAlRegister.enqueue(new Callback<ResponseAuth>() {
                    @Override
                    public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                        if(response.isSuccessful()){
                            responseAuth = response.body();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            Log.i("loggin", responseAuth.toString());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseAuth> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
