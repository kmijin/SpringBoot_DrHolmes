package com.pillgood.drholmes.api;

import com.pillgood.drholmes.api.login.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONRetrofitAPI {
    String baseURL = "http://54.180.142.226:8080/";

    @GET("drHomesUser")
    Call<List<Post>> getSpringBoot();
}