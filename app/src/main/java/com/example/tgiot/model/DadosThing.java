package com.example.tgiot.model;

import java.io.Serializable;

public class DadosThing implements Serializable {
    private String temperatura;
    private String fluxo;

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getFluxo() {
        return fluxo;
    }

    public void setFluxo(String fluxo) {
        this.fluxo = fluxo;
    }

    public DadosThing(){
        this.temperatura="0.00";
        this.fluxo="0.00";
    }

}
