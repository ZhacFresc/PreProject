package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText Username;
    EditText Password;
    String SecureId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (SecureId != null) {
            Intent intent;
            intent = new Intent(this, Account.class);
            startActivity(intent);
        } else {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            Username = findViewById(R.id.id);
            Password = findViewById(R.id.name);
        }
    }
    public void GoToRegistration(View view) {
        Intent intent;
        intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    public void Connect(View view){
        UserAPI_Get api = UserAPI_Get.retrofit.create(UserAPI_Get.class);
        final Call<User> call = api.accountGet(Login.this.Username.getText().toString());

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user = response.body();
                    if (Password.getText().toString() != null){
                        SecureId = Integer.toString(user.getId());
                        Toast.makeText(Login.this, "Вы правильно вошли", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Login.this, "Вы не правильнно что-то ввели", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Login.this, "Вы что-то сделали не правильно", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
