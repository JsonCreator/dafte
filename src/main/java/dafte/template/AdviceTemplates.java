package dafte.template;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public class AdviceTemplates {
    private static final ImmutableList<AdviceTemplate> ADVICE_TEMPLATES = generateAdviceTemplates();

    private static ImmutableList<AdviceTemplate> generateAdviceTemplates() {
        return ImmutableList.of(
                new AdviceTemplate("%s that %s %s.",
                        AdviceComponent.PONDER, AdviceComponent.DIRECTION, AdviceComponent.ACTION)
        );
    }

    public static AdviceTemplate getTemplate(Random randomSeed) {
        return ADVICE_TEMPLATES.get(randomSeed.nextInt(ADVICE_TEMPLATES.size()));
    }
}
