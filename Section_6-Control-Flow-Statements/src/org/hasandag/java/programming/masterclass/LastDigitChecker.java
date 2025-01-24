package org.hasandag.java.programming.masterclass;

/**
 * Created by : hdag
 * Date: 30.07.2019
 * Time: 08:36
 */
public class LastDigitChecker {
    public static void main(String[] args) {

    }

    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        if (isValid(number1) && isValid(number2) && isValid(number3)) {
            int number1LastDigit = number1 % 10;
            int number2LastDigit = number2 % 10;
            int number3LastDigit = number3 % 10;

            if (number1LastDigit == number2LastDigit || number1LastDigit == number3LastDigit
                    || number2LastDigit == number3LastDigit) {
                return true;
            } else {
                return false;
            }

        } else {

            return false;
        }

    }

    private static boolean isValid(int number) {
        if (number < 10 || number > 1000) {
            return false;
        } else {
            return true;
        }
    }
}
