package com.hasandag.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class PlainOld{

    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = last_id++;
        System.out.println("Creating PlainOld object with id: " + id);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(List.of("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob"));

        nameList.forEach(System.out::println);

        System.out.println("====================================");

        calculator(Integer::sum, 3, 2);

        calculator((a,b) -> a + b, 3.2, 2.5);
        //equivalent to
        calculator(Double::sum, 3.2, 2.5);


        // Supplier<PlainOld> reference = new PlainOld(); gives error
        Supplier<PlainOld> reference1 = new Supplier<PlainOld>() {
            @Override
            public PlainOld get() {
                return null;
            }
        };
        Supplier<PlainOld> reference2 = () -> new PlainOld();
        Supplier<PlainOld> reference3 = PlainOld::new;
        // none of above not running constructor, just creating a reference to constructor check with terminal output
        // because method reference is a reference to a method, it doesn't run the method, it just creates a reference to it
        // so when we call get() method, it will run the constructor

        PlainOld newPojo = reference3.get();

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator((s1,s2)-> s1 + s2, "Hello ", "World");
        calculator((s1,s2)-> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");


        BinaryOperator<String> b1 = String::concat;
        BiFunction<String,String,String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello"));

        String result = u1.apply("Hello");
        System.out.println("Result: " + result);

        Function<String, Boolean> f1 = String::isEmpty;
        boolean resultBoolean = result.transform(f1);
        System.out.println("Result boolean: " + resultBoolean);





    }

    private static <T> void calculator(BinaryOperator<T> operator, T value1, T value2) {
        T result = operator.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }

}
