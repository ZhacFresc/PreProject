package com.example.kakpobeditleny;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI_Post {
    @POST("user")

    Call<User> createPost(@Body User dataModal);
}
