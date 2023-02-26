package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void GoToPetSelect(View view) {
        Intent intent;
        intent = new Intent(this, Pet_select.class);
        startActivity(intent);
    }
    public void GoToStoreSelect(View view) {
        Intent intent;
        intent = new Intent(this, Store_select.class);
        startActivity(intent);
    }
    public void GoToLogin(View view) {
        Intent intent;
        intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}