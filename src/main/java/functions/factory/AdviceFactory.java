package functions.factory;

import functions.model.Advice;
import functions.model.Requestor;

import java.util.Random;

public class AdviceFactory {

    private static final String advice = "Daily Advice For The Engineer";

    public static Advice createAdviceFor(Requestor requestor) {
        Random randomSeed = RandomFactory.forRequestor(requestor);

        String preparedFor = requestor.getName();
        String advice = generateAdvice(randomSeed);

        return new Advice(preparedFor, requestor.getRequestedOn(), advice);
    }

    private static String generateAdvice(Random seededRandomizer) {
        return advice;
    }
}
