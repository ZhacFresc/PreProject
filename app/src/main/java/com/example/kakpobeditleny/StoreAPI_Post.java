package com.example.kakpobeditleny;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StoreAPI_Post {
    @POST("store")

    Call<User> createPost(@Body Store dataModal);
}
