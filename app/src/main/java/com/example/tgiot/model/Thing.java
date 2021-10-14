package com.example.tgiot.model;

import androidx.annotation.NonNull;

public class Thing {

    private final String nome;
    private final String url;

    public Thing(String nome, String url) {
        this.nome=nome;
        this.url=url;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
