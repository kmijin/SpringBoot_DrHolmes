package com.pillgood.drholmes.api;

import com.pillgood.drholmes.api.login.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONRetrofitAPI {
    String baseURL = "http://43.200.60.75:8080/";



    //로그인
    @POST("member/select")
    Call<List<Post>> userLogin(@Body Post post);

    //회원가입
    @POST("member/select")
    Call<List<Post>> userJoin(@Body Post post);
}