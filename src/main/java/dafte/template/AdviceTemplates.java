package dafte.template;

import com.google.common.collect.ImmutableList;
import dafte.template.components.Action;
import dafte.template.components.Facilitator;
import dafte.template.components.Impetus;
import dafte.template.components.Quandary;
import dafte.template.components.Reaction;
import dafte.template.components.Redirection;

import java.util.Random;

public class AdviceTemplates {

    private static final Action ACTION = new Action();
    private static final Facilitator FACILITATOR = new Facilitator();
    private static final Impetus IMPETUS = new Impetus();
    private static final Quandary QUANDARY = new Quandary();
    private static final Reaction REACTION = new Reaction();
    private static final Redirection REDIRECTION = new Redirection();

    private static final ImmutableList<AdviceTemplate> ADVICE_TEMPLATES = generateAdviceTemplates();

    private static ImmutableList<AdviceTemplate> generateAdviceTemplates() {
        return ImmutableList.of(
                // The Contemplation Formula
                new AdviceTemplate("%s that %s %s.",
                       QUANDARY, FACILITATOR, ACTION),
                // The Conditional Formula
                new AdviceTemplate("If the %s to %s %s, %s %s.",
                        IMPETUS, ACTION, REACTION, REDIRECTION, ACTION)
        );
    }

    public static AdviceTemplate getTemplate(Random randomSeed) {
        return ADVICE_TEMPLATES.get(randomSeed.nextInt(ADVICE_TEMPLATES.size()));
    }
}
