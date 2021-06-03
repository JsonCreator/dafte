package dafte.factory;

import dafte.model.Advice;
import dafte.model.Requestor;
import dafte.template.AdviceTemplate;
import dafte.template.AdviceTemplates;

import java.util.Random;

public class AdviceFactory {

    public static Advice createAdviceFor(Requestor requestor) {
        Random randomSeed = RandomFactory.forRequestor(requestor);

        String preparedFor = requestor.getName();
        String advice = generateAdvice(randomSeed);

        return new Advice(preparedFor, requestor.getRequestedOn(), advice);
    }

    private static String generateAdvice(Random randomSeed) {
        AdviceTemplate template = AdviceTemplates.getTemplate(randomSeed);
        return template.generate(randomSeed);
    }
}
