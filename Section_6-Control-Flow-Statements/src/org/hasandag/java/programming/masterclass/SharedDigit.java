package org.hasandag.java.programming.masterclass;

/**
 * Created by : hdag
 * Date: 30.07.2019
 * Time: 08:20
 */
public class SharedDigit {
    public static void main(String[] args) {

    }


    public static boolean hasSharedDigit(int number1, int number2) {
        if (number1 < 10 || number1 > 99 || number2 < 10 || number2 > 99) {
            return false;
        }
        int number1LastDigit = number1 % 10;
        int number1FirstDigit = number1 / 10;
        int number2LastDigit = number2 % 10;
        int number2FirstDigit = number2 / 10;

        if (number1FirstDigit == number2FirstDigit || number1FirstDigit == number2LastDigit) {
            return true;
        } else if (number1LastDigit == number2FirstDigit || number1LastDigit == number2LastDigit) {
            return true;
        }

        return false;
    }
}
