package dafte.factory;

import dafte.model.Advice;
import dafte.model.Requester;
import dafte.template.AdviceTemplate;
import dafte.template.AdviceTemplates;

import java.util.Random;

public class AdviceFactory {

    public static Advice createAdviceFor(Requester requester) {
        Random randomSeed = RandomFactory.forRequestor(requester);

        String preparedFor = requester.getName();
        String advice = generateAdvice(randomSeed);

        return new Advice(preparedFor, requester.getRequestedOn(), advice);
    }

    private static String generateAdvice(Random randomSeed) {
        AdviceTemplate template = AdviceTemplates.getTemplate(randomSeed);
        return template.generate(randomSeed);
    }
}
