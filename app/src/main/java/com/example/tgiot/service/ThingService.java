package com.example.tgiot.service;

import com.example.tgiot.model.RequestResponseTotal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ThingService {

    @GET("test/iottg")
    Call<RequestResponseTotal> buscaDados(@Query("thing_id") String thingId);
}
