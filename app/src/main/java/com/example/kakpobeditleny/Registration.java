package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    EditText Mail;
    EditText Username;
    EditText Password;
    EditText FirstName;
    EditText SecondName;
    EditText Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        Mail = findViewById(R.id.mail);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        FirstName = findViewById(R.id.first_name);
        SecondName = findViewById(R.id.second_name);
        Phone = findViewById(R.id.phone);
    }

    public void Registrate(View view){
        postData(Mail.getText().toString(), Username.getText().toString(),
                Password.getText().toString(), FirstName.getText().toString(), SecondName.getText().toString(), Phone.getText().toString());
    }
    private void postData(String mail, String username, String password, String firstname,
                          String secondname, String phone){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserAPI_Post userAPI = retrofit.create(UserAPI_Post.class);
        User modal = new User(234 ,mail, username, password, firstname, secondname, phone, 1);
        Call<User> call = userAPI.createPost(modal);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(Registration.this, "Всё ок", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Registration.this, "Что-то пошло не так", Toast.LENGTH_SHORT).show();
            }
        });
    }
}