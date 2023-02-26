package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pet_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_select);
    }
    public void GoToMainActivity(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void GoToPetSearch(View view) {
        Intent intent;
        intent = new Intent(this, Pet_search.class);
        startActivity(intent);
    }
    public void GoToPetCreate(View view) {
        Intent intent;
        intent = new Intent(this, Pet_create.class);
        startActivity(intent);
    }
    public void GoToPetChange(View view) {
        Intent intent;
        intent = new Intent(this, Pet_change.class);
        startActivity(intent);
    }
    public void GoToPetDelete(View view) {
        Intent intent;
        intent = new Intent(this, Pet_delete.class);
        startActivity(intent);
    }
}
