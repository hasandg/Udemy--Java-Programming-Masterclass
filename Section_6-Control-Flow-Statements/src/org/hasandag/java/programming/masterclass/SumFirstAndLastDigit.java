package org.hasandag.java.programming.masterclass;

/**
 * Created by : hdag
 * Date: 29.07.2019
 * Time: 14:34
 */
public class SumFirstAndLastDigit {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(10));
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }
        int lastDigit = number % 10;
        while (number >= 10){
            number /= 10;
        }
        return number + lastDigit;
    }
}
