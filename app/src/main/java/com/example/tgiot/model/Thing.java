package com.example.tgiot.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Thing implements Serializable {

    public DadosThing getDadosThing() {
        return dadosThing;
    }

    private final DadosThing dadosThing;
    private final String nome;
    private final String url;

    public Thing(String nome, String url) {
        this.nome=nome;
        this.url=url;
        dadosThing = new DadosThing();
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void updateDadosThing(DadosThing dadosThing){
        this.dadosThing.setFluxo(dadosThing.getFluxo());
        this.dadosThing.setFluxo(dadosThing.getTemperatura());
    }


    public String getUrl() {
        return url;
    }
}
