package com.hasandag.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntroMain {

    record Person(String name, String lastName) {

        @Override
        public String toString() {
            return name + " " + lastName;
        }
    }

    public static void main(String[] args) {
        // List<Person> people =  List.of(
        // If we do this way it gives error because List.of() returns an immutable list
        /* Exception in thread "main" java.lang.UnsupportedOperationException
        at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        at java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:263)
        at com.hasandag.lambda.InitialMain.main(InitialMain.java:37)*/


        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Hasan", "Dag"),
                new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Alice", "Wonderland"),
                new Person("Bob", "Builder"),
                new Person("Charlie", "Chocolate"),
                new Person("Dave", "Brown")
        ));

        // people.forEach(System.out::println);

//        var compareLastName = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName().compareTo(o2.lastName());
//            }
//        };

        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMix = new EnhancedComparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                int result = o1.lastName().compareTo(o2.lastName());
                return result == 0 ? secondLevel(o1,o2) : result;
            }

            @Override
            public int secondLevel(Person o1, Person o2){
                return o1.name().compareTo(o2.name());
            }
        };

        people.sort(comparatorMix);
        System.out.println(people);

    }
}
