package com.example.tgiot.service;

import com.example.tgiot.model.RequestResponseTotal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ThingService {

    @GET("iottg")
    Call<RequestResponseTotal> buscaDados();
}
