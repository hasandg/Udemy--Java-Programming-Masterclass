package org.hasandag.java.programming.masterclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : hdag
 * Date: 7.08.2019
 * Time: 12:07
 */
public class IsPerfectNumber {
    public static void main(String[] args) {

        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(29));
        System.out.println(isPerfectNumber(3));
    }


    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        List<Integer> allFactors = new ArrayList<>();
        allFactors.add(1);
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                allFactors.add(i);
            }
        }

        Integer total = 0;
        for (Integer factor : allFactors
        ) {
            total += factor;
        }
        return total == number;
    }

}
