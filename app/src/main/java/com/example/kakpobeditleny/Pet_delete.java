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

public class Pet_delete extends AppCompatActivity {
    EditText Id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_delete);
        Id = findViewById(R.id.id);
    }

    public void PetDelete(View view){
        PetAPI_Delete api = PetAPI_Delete.retrofit.create(PetAPI_Delete.class);
        final Call<Pet> call = api.repoPets(Integer.parseInt(Id.getText().toString()));
        call.enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                Toast.makeText(Pet_delete.this, "Он уничтожился", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
                Toast.makeText(Pet_delete.this, "Ваш питомец до сих пор у нас в магазине", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void GoToPetSelect(View view) {
        Intent intent;
        intent = new Intent(this, Pet_select.class);
        startActivity(intent);
    }
}