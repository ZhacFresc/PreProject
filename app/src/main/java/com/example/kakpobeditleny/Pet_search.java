package com.example.kakpobeditleny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pet_search extends AppCompatActivity {
    EditText Id;
    ImageView ImageView;
    TextView TextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_search);
        Id = findViewById(R.id.editText7);
        ImageView = findViewById(R.id.imageView6);
        TextView = findViewById(R.id.textView5);
    }
    public void PetFind(View view){
        PetAPI_Get api = PetAPI_Get.retrofit.create(PetAPI_Get.class);
        final Call<Pet> call = api.repoPets(Integer.parseInt(Id.getText().toString()));

        call.enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                if(response.isSuccessful()){
                    Pet pet = response.body();
                    ArrayList photo = (ArrayList) pet.getPhotoUrls();
                    TextView.setText(pet.getName());
                    if(photo != null){
                        Picasso.get().load((String) photo.get(0)).into(ImageView);
                    }
                }
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
                Toast.makeText(Pet_search.this, "Что-то пошло не так" , Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void GoToPetSelect(View view) {
        Intent intent;
        intent = new Intent(this, Pet_select.class);
        startActivity(intent);
    }
}