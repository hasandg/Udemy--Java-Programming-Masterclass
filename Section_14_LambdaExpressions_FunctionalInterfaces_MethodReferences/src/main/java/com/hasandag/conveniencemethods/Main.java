package com.hasandag.conveniencemethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

        public static void main(String[] args) {
            System.out.println("1 ----");
            String name = "Hasan";
            Function<String,String> uCase = String::toUpperCase;
            System.out.println(uCase.apply(name));

            System.out.println("2 ----");

            Function<String,String> lastName = s -> s.concat(" Dag");
            Function<String,String> uCaseLastName = uCase.andThen(lastName);
            System.out.println(uCaseLastName.apply(name));

            System.out.println("3 ----");

            uCaseLastName = uCase.compose(lastName);
            System.out.println(uCaseLastName.apply(name));

            System.out.println("4 ----");

            uCaseLastName = uCaseLastName.compose(lastName);
            System.out.println(uCaseLastName.apply(name));

            System.out.println("5 ----");

            Function<String, String[]> f0 = uCase
                    .andThen(s -> s.concat(" Dag"))
                    .andThen(s -> s.split(" "));

            System.out.println(f0.apply(name)[0]);

//         return type error!
//            Function<String, String[]> fError = uCase
//                    .andThen(s -> s.concat(" Dag"));

            System.out.println("6 ----");

            Function<String, String> f1 = uCase
                    .andThen(s -> s.concat(" Dag"))
                    .andThen(s -> s.split(" "))
                    .andThen(s -> s[1].toUpperCase() + ", " + s[0]);

            System.out.println(f1.apply(name));

            System.out.println("7 ----");

            Function<String, String> f2 = uCase
                    .andThen(s -> s.concat(" Dag"))
                    .andThen(s -> s.split(" "))
                    .andThen(s -> s[1].toUpperCase() + ", " + s[0])
                    .andThen(s -> s.concat(" - " + s.length()));
            System.out.println(f2.apply(name));

            System.out.println("8 ----");

            Function<String, String[]> f3 = uCase
                    .andThen(s -> s.concat(" Dag"))
                    .andThen(s -> s.split(" "));
                   // .andThen(s -> String.join(", ", s));
                    //.andThen(String::length);
            String[] stringArray = f3.apply(name);
            for (String s : stringArray) {
                System.out.println(s);
            }

            System.out.println("9 ----");

            String[] names = {"Ann", "Bob", "Carol"};
            Consumer<String> s0 = s -> System.out.print(s.charAt(0));
            Consumer<String> s1 = System.out::println;

            Arrays.asList(names).forEach(s0
                    .andThen(s -> System.out.print(" - "))
                    .andThen(s1));

            Predicate<String> p1 = s -> s.equals("HASAN");
            Predicate<String> p2 = s -> s.equalsIgnoreCase("Hasan");
            Predicate<String> p3 = s -> s.startsWith("H");
            Predicate<String> p4 = s -> s.endsWith("e");

            System.out.println("10 ----");

            System.out.println(p1.test(name));
            System.out.println(p2.test(name));
            System.out.println(p3.test(name));
            System.out.println(p4.test(name));

            System.out.println("11 ----");


            Predicate<String> combined1 = p1.or(p2);
            System.out.println("combined1 = " + combined1.test(name));

            Predicate<String> combined2 = p3.and(p4);
            System.out.println("combined2 = " + combined2.test(name));

            //negate() returns a predicate that represents the logical negation of this predicate.
            //Opposite result of the predicate
            Predicate<String> combined3 = p3.and(p4).negate();
            System.out.println("combined3 = " + combined3.test(name));

            record Person(String firstName, String lastName) {}

            List<Person> people = Arrays.asList(
                    new Person("Peter", "Pan"),
                    new Person("Peter", "PumpkinEater"),
                    new Person("Peter", "Alore"),
                    new Person("Minnie", "Mouse"),
                    new Person("Mickey", "Mouse"),
                    new Person("Sally", "Mouse"),
                    new Person("Ally", "Mouse")
            );

            List<Person> peopleArrayList = new ArrayList<>(Arrays.asList(
                    new Person("Peter", "Pan"),
                    new Person("Peter", "PumpkinEater"),
                    new Person("Minnie", "Mouse"),
                    new Person("Mickey", "Mouse"),
                    new Person("Sally", "Mouse"),
                    new Person("Ally", "Mouse")

            ));

            //UnsupportedOperationException
            //	at java.base/java.util.AbstractList.add(AbstractList.java:155)
            //people.add(new Person("Hasan", "Dag"));

            System.out.println("12 ->->->->->->->->->->->->->->->->->->->->->->->->");
            peopleArrayList.add(new Person("Hasan", "Dag"));

            people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
            people.forEach(System.out::println);

            System.out.println("------------------------------------");
            people.sort(Comparator.comparing(Person::lastName));
            people.forEach(System.out::println);

            System.out.println("------------------------------------");
            people.sort(Comparator.comparing(Person::lastName)
                    .thenComparing(Person::firstName));
            people.forEach(System.out::println);

            System.out.println("------------------------------------");
            people.sort(Comparator.comparing(Person::lastName)
                    .thenComparing(Person::firstName).reversed());
            people.forEach(System.out::println);


        }
}
