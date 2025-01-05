package com.hasandag.java.generics.notusinggenerics;

public class MainWithoutGenerics {

    public static void main(String[] args) {
        // Create cafe and restaurant with some employees
        Cafe cafe = new Cafe("Lavista");
        Restaurant restaurant = new Restaurant("Istanbul");
        RestaurantWorker ahmed = new RestaurantWorker("Ahmed");
        CafeWorker mehmet = new CafeWorker("Mehmet");

        // Add employees to cafe but Ahmet is a KebabMaster and he can't work in a cafe
        //no error !!!
        cafe.addEmployee(ahmed);
    }
}
