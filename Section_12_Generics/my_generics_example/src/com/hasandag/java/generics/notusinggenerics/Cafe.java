package com.hasandag.java.generics.notusinggenerics;

import java.util.ArrayList;
import java.util.List;

public class Cafe implements Enterprise{

    private String name;

    private List<Worker> workers = new ArrayList<>();

    public Cafe(String name) {
        this.name = name;
    }

    @Override
    public void addEmployee(Worker worker) {
        System.out.println("Employee " + worker.getName() + " is added to the cafe " + name);
        workers.add(worker);
    }

    @Override
    public void removeEmployee(Worker worker) {
        System.out.println("Employee " + worker.getName() + " is removed from the cafe " + name);
        workers.remove(worker);
    }

    @Override
    public String getName() {
        return name;
    }
}
