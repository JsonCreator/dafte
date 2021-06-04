package dafte.template;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public class AdviceTemplates {
    private static final ImmutableList<AdviceTemplate> ADVICE_TEMPLATES = generateAdviceTemplates();

    private static ImmutableList<AdviceTemplate> generateAdviceTemplates() {
        return ImmutableList.of(
                // The Contemplation Formula
                new AdviceTemplate("%s that %s %s.",
                        AdviceComponent.PONDER, AdviceComponent.DIRECTION, AdviceComponent.ACTION),
                // The Conditional Formula
                new AdviceTemplate("If the %s to %s %s, %s %s.",
                        AdviceComponent.IMPETUOUS, AdviceComponent.ACTION, AdviceComponent.REACTION, AdviceComponent.ALTERNATE, AdviceComponent.ACTION)
        );
    }

    public static AdviceTemplate getTemplate(Random randomSeed) {
        return ADVICE_TEMPLATES.get(randomSeed.nextInt(ADVICE_TEMPLATES.size()));
    }
}
