package functions.factory;

import java.util.Random;

public class AdviceFactory {

    private static final String advice = "Daily Advice For The Engineer";

    public static String generateAdvice(Random seededRandomizer) {
        return advice;
    }
}
