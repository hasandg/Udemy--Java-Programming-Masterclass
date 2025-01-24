package com.hasandag;

/**
 * Created by : hdag
 * Date: 19.09.2019
 * Time: 15:13
 */
public class RandomIntGenerator {


    public static double getRandomDoubleBetweenRange(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

}
