package dafte.template;

import dafte.template.components.Action;
import dafte.template.components.AdviceComponent;
import dafte.template.components.Facilitator;
import dafte.template.components.Impetus;
import dafte.template.components.Pairing;
import dafte.template.components.Quandary;
import dafte.template.components.Reaction;
import dafte.template.components.Redirection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdviceTemplate {

    protected static final Action ACTION = new Action();
    protected static final Facilitator FACILITATOR = new Facilitator();
    protected static final Impetus IMPETUS = new Impetus();
    protected static final Quandary QUANDARY = new Quandary();
    protected static final Reaction REACTION = new Reaction();
    protected static final Redirection REDIRECTION = new Redirection();
    protected static final Pairing PAIRING = new Pairing();

    protected final String template;

    protected final List<AdviceComponent> components;

    protected AdviceTemplate(String template, AdviceComponent... components) {
        this.template = template;
        this.components = Arrays.asList(components);
    }

    public String generate(Random randomSeed) {
        Object[] componentValues = components.stream()
                .map(component -> component.getComponentValue(randomSeed))
                .toArray();

        return capitalize(String.format(template, componentValues));
    }

    private String capitalize(String advice) {
        String first = advice.substring(0, 1).toUpperCase();
        return first + advice.substring(1);
    }


}
