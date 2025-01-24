package org.hasandag.java.programming.masterclass;

public class EvenDigitSum {
    public static void main(String[] args) {

    }

    public static int getEvenDigitSum(int number) {

        if(number == 0){
            return 0;
        }else if(number < 0) {
            return -1;
        }

        int sum = 0;

        while (number >0) {
            // extract the lest-significant digit
            int digit = number % 10;
            if (digit%2 == 0) {
                sum += digit;
            }

            // drop the least-significant digit
            number /= 10;   // same as number = number / 10;
        }

        return sum;
    }
}
