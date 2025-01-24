package org.hasandag.java.programming.masterclass;

public class LargestPrimeNumberSolution1 {

    public static void main(String[] args) {

        int n = 15;
        System.out.println(getLargestPrime(n));

        n = 256987513;
        System.out.println(getLargestPrime(n));
    }


        public static int getLargestPrime(int number) {
            if (number <= 1) {
                return -1;
            } else {
                int numberWithoutFoundPrimes = number;
                int greatestPrime = 1;
                for (int i = 2; i <= number; i++) {
                    while (numberWithoutFoundPrimes % i == 0) {
                        greatestPrime = i;
                        numberWithoutFoundPrimes /= i;
                    }
                }
                return greatestPrime;
            }
        }

}
