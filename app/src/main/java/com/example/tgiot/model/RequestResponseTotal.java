package com.example.tgiot.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestResponseTotal {

    @SerializedName("flow")
    @Expose
    private String flow;
    @SerializedName("temp")
    @Expose
    private String temp;

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

}