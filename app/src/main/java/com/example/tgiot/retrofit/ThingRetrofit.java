package com.example.tgiot.retrofit;

import com.example.tgiot.service.ThingService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThingRetrofit {

    private final ThingService thingService;

    public ThingRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://3imzbbkw32.execute-api.sa-east-1.amazonaws.com/").addConverterFactory(GsonConverterFactory.create()).build();

        thingService = retrofit.create(ThingService.class);
    }

    public ThingService getThingService() {
        return thingService;
    }

}
