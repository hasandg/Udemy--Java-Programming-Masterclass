package com.hasandag.java.generics.notusinggenerics;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Enterprise {

    private String name;

    private List<Worker> workers = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    public void addEmployee(Worker worker) {
        System.out.println("Employee " + worker.getName() + " is added to the restaurant " + name);
        workers.add(worker);
    }

    public void removeEmployee(Worker worker) {
        System.out.println("Employee " + worker.getName() + " is removed from the restaurant " + name);
        workers.remove(worker);
    }


}
