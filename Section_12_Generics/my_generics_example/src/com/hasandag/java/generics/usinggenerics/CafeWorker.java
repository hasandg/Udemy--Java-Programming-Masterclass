package com.hasandag.java.generics.usinggenerics;

public class CafeWorker implements Worker {

    private String name;

    public CafeWorker(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
