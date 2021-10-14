package com.example.tgiot.model;

import java.util.HashMap;
import java.util.Map;

public class DeviceData {

    private String flow;
    private String tempe;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getTempe() {
        return tempe;
    }

    public void setTempe(String tempe) {
        this.tempe = tempe;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}