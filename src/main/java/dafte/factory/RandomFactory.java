package dafte.factory;

import dafte.model.Requestor;

import java.util.Random;

public class RandomFactory {

    public static Random forRequestor(Requestor requestor) {
        if (requestor.getName() != null) {
            return new Random(generateSeed(requestor));
        }

        return new Random();
    }

    private static long generateSeed(Requestor requestor) {
        long nameSum = 0L;
        long epochDay = requestor.getRequestedOn().toEpochDay();

        for (Character character : requestor.getName().toCharArray()) {
            nameSum += Character.getNumericValue(character);
        }

        return nameSum + epochDay;
    }
}
