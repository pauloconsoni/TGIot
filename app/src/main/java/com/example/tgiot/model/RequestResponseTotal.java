package com.example.tgiot.model;

import java.util.HashMap;
import java.util.Map;
public class RequestResponseTotal {

    private DeviceData deviceData;
    private String timeStamp;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DeviceData getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(DeviceData deviceData) {
        this.deviceData = deviceData;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}