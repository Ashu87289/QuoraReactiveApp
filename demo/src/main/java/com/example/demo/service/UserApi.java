package com.example.demo.service;

import com.example.demo.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface UserApi {

    @GET("/user")
    Call<List<User>> fetchUser();
}
