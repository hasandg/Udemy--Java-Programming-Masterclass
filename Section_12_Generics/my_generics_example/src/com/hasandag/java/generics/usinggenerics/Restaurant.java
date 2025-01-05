package com.hasandag.java.generics.usinggenerics;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Enterprise<RestaurantWorker> {

    public Restaurant(String name) {

        super(name);
    }

}
