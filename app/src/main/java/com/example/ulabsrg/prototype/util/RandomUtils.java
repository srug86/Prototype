package com.example.ulabsrg.prototype.util;

import java.util.Random;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class RandomUtils {
    private static final Random RANDOM = new Random();
    private static final int CENT_PERCENT = 101;

    private RandomUtils() {
        //Empty
    }

    /**
     * Return true of false using a random value generated and the percentage passed as parameter.
     *
     * @param percentage to evaluate.
     * @return true fifty percent of the times it's executed if the percentage parameter is 50.
     */
    public static boolean percent(final int percentage) {
        return (RANDOM.nextInt(CENT_PERCENT) < percentage);
    }

    /**
     * Returns a random integer between 0 and the maxValue argument, included maxValue.
     */
    public static int getRandomValueBelow(final int maxValue) {
        return RANDOM.nextInt(maxValue + 1);
    }
}
