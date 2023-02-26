package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Store_create extends AppCompatActivity {
    EditText Id;
    EditText Data;
    EditText IdPet;
    EditText Numbers;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_create);

        Id = findViewById(R.id.id);
        Data = findViewById(R.id.data);
        IdPet = findViewById(R.id.name);
        Numbers = findViewById(R.id.numbers);
    }

    public void GoToStoreSelect(View view) {
        Intent intent;
        intent = new Intent(this, Store_select.class);
        startActivity(intent);
    }
}

