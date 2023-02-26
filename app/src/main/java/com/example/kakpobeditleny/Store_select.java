package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Store_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_select);
    }
    public void GoToMainActivity(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void GoToStoreSearch(View view) {
        Intent intent;
        intent = new Intent(this, Store_search.class);
        startActivity(intent);
    }
    public void GoToStoreCreate(View view) {
        Intent intent;
        intent = new Intent(this, Store_create.class);
        startActivity(intent);
    }
    public void GoToStoreDelete(View view) {
        Intent intent;
        intent = new Intent(this, Store_delete.class);
        startActivity(intent);
    }
}
