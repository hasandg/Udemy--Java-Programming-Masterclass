package org.hasandag.java.programming.masterclass;

public class PrimeCount {
    public static void main(String[] args) {

        // Create a for statement using any range of numbers
        // Determine if the number is a prime number using the isPrime method
        // if it is a prime number, print it out AND increment a count of the
        // number of prime numbers found
        // if that count is 3 exit the for loop
        // hint:  Use the break; statement to exit

        int primeCount = 0;
        for (int i = 3; i < 9; i++) {
            boolean prime = isPrime(i);
            if(prime){
                System.out.println(i+ " is prime number!");
                primeCount++;
            }
            if(primeCount>=3){
                System.out.println("we have 3 prime number, loop will be finish!!!");
                break;
            }
        }

    }


    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            //System.out.println("Looping " + i);
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }
}
