package org.hasandag.java.programming.masterclass;

/**
 * Created by : hdag
 * Date: 29.07.2019
 * Time: 13:55
 */
public class IsPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome(-222));
    }

    public static boolean isPalindrome(int number) {
        int firstNumber = number;
        int reverse = 0;
        if (number == 0) {
            return true;
        }
        while (number != 0) {
            int lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }

        if (reverse == firstNumber) {
            return true;
        } else {
            return false;
        }
    }


   /* public static boolean isPalindrome( int number){

       int num = number;
       int reverse = 0;
       int i = 0;

       while (num != 0){

           int lastDigit =num %10;
           reverse*= 10;
           reverse+= lastDigit;
           num /= 10;
       }

       if (number == reverse){
           return true;
       }
       return false;

   }*/
}
