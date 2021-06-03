package dafte.factory;

import dafte.model.Requester;

import java.util.Random;

public class RandomFactory {

    public static Random forRequestor(Requester requester) {
        if (requester.getName() != null) {
            return new Random(generateSeed(requester));
        }

        return new Random();
    }

    private static long generateSeed(Requester requester) {
        long nameSum = 0L;
        long epochDay = requester.getRequestedOn().toEpochDay();

        for (Character character : requester.getName().toCharArray()) {
            nameSum += Character.getNumericValue(character);
        }

        return nameSum + epochDay;
    }
}
