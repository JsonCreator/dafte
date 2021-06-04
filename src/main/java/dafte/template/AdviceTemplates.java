package dafte.template;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public class AdviceTemplates {

    private static final ImmutableList<AdviceTemplate> ADVICE_TEMPLATES = ImmutableList.of(
            new Contemplation(),
            new Conditional(),
            new CauseAndEffect());

    public static AdviceTemplate getTemplate(Random randomSeed) {
        return ADVICE_TEMPLATES.get(randomSeed.nextInt(ADVICE_TEMPLATES.size()));
    }

    static public class Contemplation extends AdviceTemplate {
        public Contemplation() {
            super("%s that %s %s.",
                    QUANDARY, FACILITATOR, ACTION);
        }
    }

    static public class Conditional extends AdviceTemplate {
        public Conditional() {
            super("if the %s to %s %s, %s to %s.",
                    IMPETUS, ACTION, REACTION, REDIRECTION, ACTION);
        }
    }

    static public class CauseAndEffect extends AdviceTemplate {
        public CauseAndEffect() {
            super("when you %s %s %s, your %s to %s %s.",
                    ACTION, PAIRING, ACTION, IMPETUS, ACTION, REACTION);
        }
    }
}
