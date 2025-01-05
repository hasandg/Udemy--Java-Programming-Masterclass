package com.hasandag.java.generics.usinggenerics;

import java.util.ArrayList;
import java.util.List;

public class Enterprise<T extends Worker>{
    private String name;
    private List<T> workers = new ArrayList<>();

    public Enterprise(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    void addWorker(T worker) {
        System.out.println("Worker " + worker.getName() + " is added to " + name);
        workers.add(worker);
    }

    void removeWorker(T worker){
        System.out.println("Worker " + worker.getName() + " is removed from " + name);
        workers.remove(worker);
    }
}
