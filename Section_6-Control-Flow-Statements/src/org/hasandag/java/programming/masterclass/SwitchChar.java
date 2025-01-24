package org.hasandag.java.programming.masterclass;

public class SwitchChar {

    public static void main(String[] args) {

        char switchChar = 'H';

        switch (switchChar) {
            case 'A':
                System.out.println("switchChar is A!");
                break;
            case 'B':
                System.out.println("switchChar is B!");
                break;
            case 'C':
                System.out.println("switchChar is C!");
                break;
            case 'D':
                System.out.println("switchChar is D!");
                break;
            case 'E':
                System.out.println("switchChar is E!");
                break;
            default:
                System.out.println("Not found");
                break;
        }


    }

}
