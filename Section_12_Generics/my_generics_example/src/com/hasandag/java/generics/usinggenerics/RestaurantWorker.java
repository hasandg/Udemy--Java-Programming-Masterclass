package com.hasandag.java.generics.usinggenerics;

public class RestaurantWorker implements Worker {

    private String name;


    public RestaurantWorker(String name) {
       this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }
}
