package com.hasandag.java.generics.usinggenerics;

import java.util.ArrayList;
import java.util.List;

public class Cafe extends Enterprise<CafeWorker> {

    public Cafe(String name) {
        super(name);
    }

}
