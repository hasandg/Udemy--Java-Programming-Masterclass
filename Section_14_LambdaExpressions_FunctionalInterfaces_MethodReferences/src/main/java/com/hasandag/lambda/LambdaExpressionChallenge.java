package com.hasandag.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaExpressionChallenge {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] namesArray = {"Hasan", "Bob", "Alice", "John", "Mary"};

        Arrays.setAll(namesArray, i -> namesArray[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(namesArray));

        List<String> backedByArray = Arrays.asList(namesArray);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(backedByArray);

        backedByArray.replaceAll(s -> s += " " + getReverseString(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        //System.out.println(backedByArray);
        Arrays.asList(namesArray).forEach(System.out::println);

        List<String> newList = new ArrayList<>(List.of(namesArray));
//        newList.removeIf(s -> {
//            String first = s.substring(0, s.indexOf(" "));
//            String last = s.substring(s.lastIndexOf(" ") + 1);
//            return first.equals(last);
//        });
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));
        System.out.println("--> Remove names with same first and last name");
        newList.forEach(System.out::println);


        // List<String> names = new ArrayList<>(List.of(new String[]{"Hasan", "Bob", "Alice", "John", "Mary"}));
        List<String> names = new ArrayList<>(Arrays.asList(new String[]{"Hasan", "Bob", "Alice", "John", "Mary"}));

        names.replaceAll(s -> s.toUpperCase());
        //or

        // names.forEach(System.out::println);

        names.replaceAll(s -> s + " - " + new StringBuilder(s).reverse());

        // names.forEach(System.out::println);

        //names.removeIf(s -> new StringBuilder(s).);

    }

    public static char getRandomChar(char startChar, char endChar) {
        // return (char) (startChar + random.nextInt(endChar - startChar + 1));
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String getReverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }


}
