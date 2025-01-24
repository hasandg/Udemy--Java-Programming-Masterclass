package org.hasandag.java.programming.masterclass;

/**
 * Created by : hdag
 * Date: 7.08.2019
 * Time: 16:54
 */
public class FlourPacker {

    public static void main(String[] args) {
      System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(1, 0, 6));
        System.out.println(canPack(0, 5, 4));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        } else {
            for (int i = 0; i <= bigCount; i++) {
                for (int j = 0; j <= smallCount; j++) {

                    //System.out.println("inner for i " + i + " j " + j);
                    if ( i * 5 + j == goal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


