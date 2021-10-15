package com.example.tgiot.service;

import com.example.tgiot.model.RequestResponseTotal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ThingService {

    @GET("prod/{url}")
    Call<RequestResponseTotal> buscaDados(@Path("url") String url);
}
