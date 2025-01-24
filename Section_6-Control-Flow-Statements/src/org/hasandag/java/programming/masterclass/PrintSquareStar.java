package org.hasandag.java.programming.masterclass;

public class PrintSquareStar {
    public static void main(String[] args) {

        printSquareStar(5);
        printSquareStar(8);
    }


    public static void printSquareStar(int n) {
        if (n < 5) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || i == n || j == n)
                    System.out.print("*");
                else if (i == j || i == n - j + 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
