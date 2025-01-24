package com.hasandag.conveniencemethods;

import com.hasandag.lambda.IntroMain;

import java.util.function.Function;

public class MainAndThenAndCompose {

    public static void main(String[] args) {

        Function<Integer,Integer> sum2 = integer -> integer + 2;
        Function<Integer,Integer> multiply5 = integer -> integer * 5;

        System.out.println("1 ----");
        System.out.println(sum2.andThen(multiply5).apply(3));

        System.out.println("2 ----");
        System.out.println(sum2.compose(multiply5).apply(3));



    }
}
