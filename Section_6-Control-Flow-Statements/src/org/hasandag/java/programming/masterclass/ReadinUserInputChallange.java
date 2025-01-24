package org.hasandag.java.programming.masterclass;

import java.util.Scanner;

public class ReadinUserInputChallange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i =1;
        int total = 0;

        while(i<10){
            System.out.println("Enter number #"+i);
            if(scanner.hasNextInt()){
                int number = scanner.nextInt();
                total += number;

                i++;
            }else{
                System.out.println("Invalid Input");
            }
            scanner.nextLine();
        }
        System.out.println("Total number is: " + total);
        scanner.close();

    }
}
