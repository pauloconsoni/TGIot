package com.example.tgiot.dao;

import com.example.tgiot.model.Thing;

import java.util.ArrayList;
import java.util.List;

public class ThingDAO {

    private final static List<Thing> things = new ArrayList<>();

    public void salva(Thing thing) {
        things.add(thing);
    }

    public List<Thing> todos() {
        return new ArrayList<>(things);
    }
}